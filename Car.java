package lab10;

import java.awt.Color;
import sedgewick.StdDraw;
import lab10.ArcadeKeys;
import java.awt.event.KeyEvent;

public class Car implements Object2{

	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public boolean rl;
	
	public Car(double posX, double posY, double speed, boolean rl){
		length = 0.02;
		width = 0.05;
		this.posX = posX;
		this.posY = posY;
		color = Color.RED;
		this.speed = speed;
		this.rl = rl;
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
		if (rl) {
            posX += speed;
        }
        else {
            posX -= speed;
        }
        if (posX >= 1.0) {
            posX=0;
        }
        else if (posX <= 0.0) {
            posX=1;
        }
//		posX += speed;
//		if (posX >= 1.0){posX = 0.0;}
	}

	@Override
	public void draw() {
		StdDraw.picture(posX, posY, "images/Yellow Car 05x.png");
//		StdDraw.picture(posX, posY, "images/Yellow Car (30x60).png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public void draw2() {
		StdDraw.picture(posX, posY, "images/police car 05x.png");
//		StdDraw.setPenColor(color);
//		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
}
