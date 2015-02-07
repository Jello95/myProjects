package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Rocket implements Object2{

	public double length;
	public double width;
	
	public double posX;
	public double posY;
	public Color color;
	public double speed;
	
	public Rocket(double posX, double posY, double speed){
		length = 0.10;
		width = 0.05;
		this.posX = posX;
		this.posY = posY;
		color = Color.CYAN;
		this.speed = speed;
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
		boolean x = ArcadeKeys.isKeyPressed(1, ArcadeKeys.KEY_A);
		if (x) {
			posY += speed;
			if (posY >= 1.0){posY = 1.0; StdDraw.setPenColor();}
		}
	}
	
	public void move2() {
		boolean y = ArcadeKeys.isKeyPressed(0, ArcadeKeys.KEY_A);
		if (y) {
			posY += speed;
			if (posY >= 1.0){posY = 1.0; StdDraw.setPenColor();}
		}
	}

	@Override
	public void draw() {
		StdDraw.picture(getposX(), getposY(), "images/RRrocket.jpg");
//		StdDraw.picture(getposX(), getposY(), "images/missile.png");
	}
	
	public boolean clear(){
		return true;
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
}
