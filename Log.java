package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Log implements Object2{
	
	public double length;
	public double width;
	public double width2;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	public boolean rl;
	
	public Log(double posX, double posY, double speed, boolean rl){
		length = 0.037;
		width = 0.07;
		width2 = 0.13;
		this.posX = posX;
		this.posY = posY;
		color = StdDraw.GRAY;
		this.speed = speed;
		this.rl=rl;
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
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledRectangle(posX, posY, width, length);
		StdDraw.picture(posX, posY, "images/log 1x.png");
	}
	
	public void draw2() {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(posX, posY, width2, length);
//		StdDraw.picture(posX, posY, "images/police car 05x.png");
//		StdDraw.picture(posX, posY, "images/LOng Truck 2x.png");
		StdDraw.picture(posX, posY, "images/Sea (30x128).png");
	}

	public static void main(String[] args) {

	}
}
