package gui;

import genetic.algorithm.Turtle;
import genetic.algorithm.World;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.Timer;

public class TurtlePlayer extends SwingWorker<Turtle, Turtle> {

	private static final TurtlePlayer theTurtlePlayer = new TurtlePlayer();

	public static TurtlePlayer getInstance() {
		return theTurtlePlayer;
	}

	private Turtle turtle, bestTurtle;
	private ArrayList<Turtle> bestTurtles = new ArrayList<Turtle>();
	private final World theWorld = World.getInstance();
	private final TurtleField theField = TurtleField.getInstance();

	private TurtlePlayer() {
		bestTurtle = new Turtle();
		bestTurtle.fitness = Double.MAX_VALUE;

	}

	@Override
	protected Turtle doInBackground() throws Exception {
		while (!theWorld.getCurrentGen().done()) {

			// get current turtle
			turtle = theWorld.getCurrentGen().getCurrentTurtle();
			// update display

			// run through path and calculate fitness
			while (!turtle.done()) {
				turtle.calculateFitness();
			}

			// check if its a new best
			if (turtle.fitness < bestTurtle.fitness) {
				bestTurtle = turtle.clone();
				// show path/log/print fitness
				bestTurtles.add(bestTurtle);
				process(bestTurtles);
				bestTurtles.clear();
			} else {
				process(null);
			}

			theWorld.getCurrentGen().nextTurtle();
		}
		theWorld.nextGen();
		if (theWorld.getIndex() < World.GEN_LIM) {
			doInBackground();
		}
		return bestTurtle;
	}

	@Override
	protected void done() {
		JOptionPane.showMessageDialog(WorldFrame.getInstance(),
				"Generation Limit Reached: Path Optimization Complete");
	}

	@Override
	protected void process(List<Turtle> turtles) {
		if (turtles == null) {
			ControlPanel.genNumber.setText("gen: " + theWorld.getIndex());
		} else {
			Collections.sort(turtles);
			Turtle bestTurtle = turtles.get(0);
			ControlPanel.genNumber.setText("gen: " + theWorld.getIndex());
			ControlPanel.turtleNumber.setText("turtle: "
					+ theWorld.getCurrentGen().getIndex());
			theField.drawTurtle(bestTurtle);
		}
	}
}
