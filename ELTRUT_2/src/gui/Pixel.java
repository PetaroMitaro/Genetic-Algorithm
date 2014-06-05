package gui;


public class Pixel {

	public static final int S = 20;
	public boolean on = false;
	public int x, y;

	// x ranges from 0 to World.W
	// y ranges from 0 to World.H

	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
		on = false;
	}
}
