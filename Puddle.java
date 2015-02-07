package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class Puddle implements Object2{

	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public Puddle(double posX, double posY){
		length = 0.03;
		width = 0.03;
		this.posX = posX;
		this.posY = posY;
		color = Color.BLUE;
		speed = 0;
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
		return;
	}

	@Override
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledRectangle(posX, posY, width, length);
	}
	
	public static void main(String[] args) {

	}
	
}
