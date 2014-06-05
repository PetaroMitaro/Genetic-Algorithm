package gui;

import genetic.algorithm.Location;

import java.awt.Color;
import java.awt.Graphics;

public class Path {

	Location from, to;
	double length;

	Path(Location from, Location to) {
		this.from = from;
		this.to = to;
		length = Location.lengthBetween(from, to);
	}

	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.drawLine(Pixel.S * from.x + Pixel.S / 2, Pixel.S * from.y + Pixel.S
				/ 2, Pixel.S * to.x + Pixel.S / 2, Pixel.S * to.y + Pixel.S / 2);
		g.setColor(Color.gray);
		g.fillRect(Pixel.S * from.x, Pixel.S * from.y, Pixel.S, Pixel.S);
		g.setColor(Color.red);
		g.fillRect(Pixel.S * to.x, Pixel.S * to.y, Pixel.S, Pixel.S);
	}

	@Override
	public String toString() {
		return from.x + "," + from.y + " -> " + to.x + "," + to.y;
	}

}
