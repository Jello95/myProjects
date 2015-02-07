package lab10;

import java.awt.Color;

import sedgewick.StdDraw;

public class River implements Object2{
	
	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public River(){
		length = 0.25;
		width = 1.0;
		posX = 0.5;
		posY = 0.7;
		color = StdDraw.BLUE;
		speed = 0.0;
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
