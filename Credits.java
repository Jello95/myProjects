package lab10;

import java.awt.Color;
import sedgewick.StdDraw;

public class Credits implements Object2 {
	
	public double length;
	public double width;
	
	public double posX;
	public double posY;
	
	public Color color;
	public double speed;
	
	public Credits(){
		posX = 0.5;
		posY = -0.9;
		length = 0;
		width = 0;
		color = Color.WHITE;
		speed = 0.01;
	}
	
	/**
	 * Returns the horizontal position.
	 */
	
	@Override
	public double getposX() {
		return posX;
	}
	
	/**
	 * Returns vertical position.
	 */
	@Override
	public double getposY() {
		return posY;
	}
	
	/**
	 * Returns width.
	 */
	@Override
	public double getWidth() {
		return width;
	}
	
	/**
	 * Returns length.
	 */
	@Override
	public double getLength() {
		return length;
	}
	
	/**
	 * Moves credits up.
	 */
	@Override
	public void move() {
		posY+=speed;
		if(posY==1.0){System.out.println(posY);}
	}
	
	/**
	 * Draws evenly spaced text.
	 */
	@Override
	public void draw() {
		double i = 0.05;
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.text(posX, posY+18*i, "For thousands of years the Amazonians and the ");
		StdDraw.text(posX, posY+17*i,"Applachians lived together in harmony. Then the ");
		StdDraw.text(posX, posY+16*i, "comet struck the earth and changed everything.");
		StdDraw.text(posX, posY+15*i, "Froglandia became uninhabitable and so began the ");
		StdDraw.text(posX, posY+14*i, "race to build vessels that would send individuals ");
		StdDraw.text(posX, posY+13*i, "to the moon. These frogs would have to leave behind ");
		StdDraw.text(posX, posY+12*i, "the home they once knew in order to ensure the ");
		StdDraw.text(posX, posY+11*i, "survival of the species. The rest would remain ");
		StdDraw.text(posX, posY+10*i, "on Earth to die a slow and painful death. ");
		StdDraw.text(posX, posY+9*i, "");
		StdDraw.text(posX, posY+8*i, "Once the greatest possible number of ships was ");
		StdDraw.text(posX, posY+7*i,"produced, the Council of Elders agreed to send all ");
		StdDraw.text(posX, posY+6*i, "of the females in the largest of the ships, leaving ");
		StdDraw.text(posX, posY+5*i, "enough ships for five males. They then nominated your ");
		StdDraw.text(posX, posY+4*i, "father and his Amazonian brethren to board the ");
		StdDraw.text(posX, posY+3*i, "remaining pods because their seed was robust and was ");
		StdDraw.text(posX, posY+2*i, "therefore better suited to endure the moon's harsh ");
		StdDraw.text(posX, posY+1*i, "climate. But your father's Applachian rival and his ");
		StdDraw.text(posX, posY, "gang of thugs had other plans in mind. ");
	}
	
	public static void main(String[] args) {

	}
}
