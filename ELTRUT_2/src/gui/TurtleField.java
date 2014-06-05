package gui;

import genetic.algorithm.Location;
import genetic.algorithm.Turtle;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class TurtleField extends Field {

	private static final TurtleField theField = new TurtleField();
	private double pathLength;

	public static TurtleField getInstance() {
		return theField;
	}

	private ArrayList<Path> paths = new ArrayList<Path>();

	private TurtleField() {
		super(WorldFrame.getInstance());

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// draw paths
		int sum = 0;
		
		for (Path p : paths) {
			p.draw(g);
			sum += p.length;
		}
		ControlPanel.bestTurtleFitness.setText("Len: " + sum);
	}

	public void drawTurtle(Turtle bestTurtle) {
		// add paths
		paths.clear();
		for (int i = 0; i < bestTurtle.locations.size() - 1; i++) {
			Location l1 = bestTurtle.locations.get(i);
			Location l2 = bestTurtle.locations.get(i + 1);
			Path p = new Path(l1, l2);
			paths.add(p);
		}
		this.repaint();
	}

}
