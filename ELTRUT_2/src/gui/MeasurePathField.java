package gui;

import genetic.algorithm.Location;
import genetic.algorithm.Master;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;

public class MeasurePathField extends Field implements MouseListener {

	private static final MeasurePathField theClickableField = new MeasurePathField();
	public ArrayList<Path> paths = new ArrayList<Path>();
	Location currentLoc, lastLoc;

	public static MeasurePathField getInstance() {
		return theClickableField;
	}

	private MeasurePathField() {
		super(CreateMasterFrame.getInstance());
		this.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Location l : Master.getInstance().locations) {
			g.setColor(Color.white);
			g.fillRect(Pixel.S * l.x, Pixel.S * l.y, Pixel.S, Pixel.S);
		}

		int sum = 0;
		for (Path p : paths) {
			p.draw(g);
			sum += p.length;
		}
		MeasurePathFrame.getInstance().lengthLabel.setText("Len: " + sum);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		int nearestX = Math.round(me.getX() / Pixel.S);
		int nearestY = Math.round(me.getY() / Pixel.S);
		Location currentLoc = new Location(nearestX, nearestY);

		if (paths.isEmpty()) {
			lastLoc = currentLoc;
		}
		Path path = new Path(lastLoc, currentLoc);
		paths.add(path);
		lastLoc = currentLoc;
		super.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent me) {
	}

	@Override
	public void mouseExited(MouseEvent me) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
