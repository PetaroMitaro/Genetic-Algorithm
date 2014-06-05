package gui;

import genetic.algorithm.Location;
import genetic.algorithm.Master;
import genetic.algorithm.World;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MasterField extends Field {

	private static final MasterField theMasterField = new MasterField();

	public static MasterField getInstance() {
		return theMasterField;
	}

	private MasterField() {
		super(null);
	}

	public void setOwnedByWorldFrame() {
		super.parentFrame = WorldFrame.getInstance();
		this.repaint();
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, World.W * Pixel.S, World.H * Pixel.S);
		for (Location l : Master.getInstance().locations) {
			g.setColor(Color.white);
			g.fillRect(Pixel.S * l.x, Pixel.S * l.y, Pixel.S, Pixel.S);
		}
	}
}
