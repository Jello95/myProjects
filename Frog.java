package lab10;

import java.awt.Color;

import sedgewick.StdAudio;
import sedgewick.StdDraw;
import lab10.ArcadeKeys;

import java.awt.event.KeyEvent;

//import static org.junit.Assert.*;

public class Frog implements Object2{
	
	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public Frog(double posX, double posY, Color color){
		length = 0.02;
		width = 0.02;
		this.posX = posX;
		this.posY = posY;
		this.color = color;
		speed = 0.04;
	}
	
	@Override
	public double getposX() {
		return posX;
	}

	@Override
	public double getposY() {
		return posY;
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getLength() {
		return length;
	}

	@Override
	public void move() {
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP)) {
			StdDraw.clear();
			StdDraw.filledRectangle(0.5, 0.5, 1.0, 1.0);
			StdDraw.picture(posX, posY, "images/(rr)greenFrogRest.png");
			posY += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY >= 1.0){posY = 1.0;}
		}
		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_DOWN)) {
			posY -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY <= 0.0){posY = 0.0;}
		}
		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_RIGHT)) {
			posX += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX >= 1.0){posX = 1.0;}
		}

		else if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_LEFT)) {
			posX -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX <= 0.0){posX = 0.0;}
		}
	}
	
	public void move2() {
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_UP)){
			StdDraw.clear();
			StdDraw.filledRectangle(0.5, 0.5, 1.0, 1.0);
			StdDraw.picture(posX, posY, "images/(rr)orangeFrogRest.png");
			posY += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY >= 1.0){posY = 1.0;}
		}
		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_DOWN)) {
			posY -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posY <= 0.0){posY = 0.0;}
		}
		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_RIGHT)) {
			posX += speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX >= 1.0){posX = 1.0;}
		}

		else if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_LEFT)) {
			posX -= speed;
			StdAudio.play("sound/Frog Croak (One Click).wav");
			if (posX <= 0.0){posX = 0.0;}
		}
	}

	@Override
	public void draw() {
		StdDraw.picture(posX, posY, "images/(rr)greenFrogMove.png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public void draw2() {
		StdDraw.picture(posX, posY, "images/(rr)orangeFrogMove.png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public boolean collide(Object2 o){
		double a = this.getposX()+this.getWidth();
		double b = o.getposX()+o.getWidth();
		double c = this.getposX()-this.getWidth();
		double d = o.getposX()-o.getWidth();
		
		double e = this.getposY()+this.getWidth();
		double f = o.getposY()+o.getLength();
		double g = this.getposY()-this.getWidth();
		double h = o.getposY()-o.getLength();
		
		boolean m = (a>d) && (a<b); // right edge
		boolean n = (c>d) && (c<b); // left edge
		boolean x = (e>h) && (e<f); // top edge
		boolean y = (g>h) && (g<f); // bottom edge
		
		if ((m || n) && (x || y)){return true;}
		else {return false;}
	}
	
	public Rocket fireMissile(){
		Rocket one = null;
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_A)) {
			Rocket r = new Rocket(getposX(), getposY(), speed+0.03);
//			System.out.println("fire");
			one = r;
		}
		return one;
	}
	
	public Rocket fireMissile2(){
		Rocket two = null;
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_A)) {
			Rocket r = new Rocket(getposX(), getposY(), speed+0.03);
//			System.out.println("fire");
			two = r;
		}
		return two;
	}
	
	public Puddle leavePuddle(){
		Puddle x = null;
		boolean one = true;
		boolean two = true;
		boolean three = true;
		boolean four = true;
		boolean five = true;
		boolean six = true;
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_B)&&one) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash1");
			x = p;
			one = false;
		}
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_C)&&two) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash2");
			x = p;
			two = false;
		}
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_D)&&three) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash3");
			x = p;
			three = false;
		}
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_E)&&four) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash4");
			x = p;
			four = false;
		}
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_F)&&five) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash5");
			x = p;
			five = false;
		}
		if (ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_G)&&six) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash6");
			x = p;
			six = false;
		}
		return x;
	}
	
	public Puddle leavePuddle2(){
		Puddle x = null;
		boolean one = true;
		boolean two = true;
		boolean three = true;
		boolean four = true;
		boolean five = true;
		boolean six = true;
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_B)&&one) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash1");
			x = p;
			one = false;
		}
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_C)&&two) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash2");
			x = p;
			two = false;
		}
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_D)&&three) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash3");
			x = p;
			three = false;
		}
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_E)&&four) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash4");
			x = p;
			four = false;
		}
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_F)&&five) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash5");
			x = p;
			five = false;
		}
		if (ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_G)&&six) {
			Puddle p = new Puddle(getposX(), getposY()+0.1);
//			System.out.println("splash6");
			x = p;
			six = false;
		}
		return x;
	}

//	&&y
//	boolean y = ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_UP);
//	while(r.getposY()<1.0){
//	r.move();
//	r.draw();
//}
//	if(assertEquals(o.posX, this.posX, 0.3)>0){
//	return true;
//	}
//	double dx = Math.abs(this.posX - Object.posX);
//	System.out.println(dx);
//	double dy = Math.abs(this.posY - Object.posY);
//	double maxDX = Math.abs(this.width - Object.width);
//	System.out.println(maxDX);
//	double maxDY = Math.abs(this.length - Object.length);
//	boolean a = (dx<=maxDX);
//	boolean b = (dy<=maxDY);
//	if (a && b){return true;}
//	if ((Object.posX == this.posX)
//			&& (Object.posY == this.posY)
//			){
//		return true;
//	}
	
////boolean a = r.getposY()<1.0;
//////boolean b = r.getposY()<0.0;
//////boolean c = r.getposX()<1.0;
//////boolean d = r.getposX()<0.0;
////	while(a 
//////			&& b && c && d
////			){
////	for (int i=0; i<o.length; i++){
////		if (!r.collide(o[i])){
////		System.out.println(r.collide(o[i]));
//	
////	if (!r.collide(o)){
////		System.out.println(r.collide(o));
//		while(r.getposY()<1.0){
////			r.clear();
//			r.move();
//			r.draw();
//		}
////		return false;
////	}
////	else {
////		return true;
////	}
//		
////		else{
////			o[i].clear();
////		}
////		}
}
