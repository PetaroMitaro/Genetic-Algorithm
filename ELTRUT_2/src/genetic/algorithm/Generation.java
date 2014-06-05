package genetic.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Generation extends ArrayList<Turtle> {

	private Turtle currentTurtle;
	private int index = 0;

	public Generation(Generation parents) {
		super();
		if (parents == null) {
			randomGen();
		} else {
			newGenFromParents(parents);

		}
		currentTurtle = this.get(0);
	}

	public Turtle getCurrentTurtle() {
		currentTurtle = this.get(index);
		return currentTurtle;
	}

	public void nextTurtle() {
		index++;
	}

	public boolean done() {
		return index > size() - 1;
	}

	public int getIndex() {
		return index;
	}

	private void randomGen() {
		for (int i = 0; i < World.GEN_SIZE; i++) {
			Turtle t = new Turtle();
			t.fillLocationList();
			this.add(t);
		}
	}

	private void newGenFromParents(Generation parents) {

		Collections.sort(parents);

		// highest path turtles are removed
		parents.killTheWeak();

		// pair up into twos
		Collections.shuffle(parents);

		for (int i = 0; i < (parents.size()); i++) {
			Turtle mom = parents.get(i);
			Turtle dad = parents.get(parents.size() - 1 - i);
			makeBabies(this, mom.clone(), dad.clone(), parents);
		}

	}

	private void killTheWeak() {
		int cutoff = (int) (0.5 * size());
		if (cutoff < this.size() && cutoff > 0) {
			removeRange(0, cutoff);
		}
	}

	private static void makeBabies(Generation babies, Turtle mom, Turtle dad,
			Generation parentGen) {
		// mutate parents
		mom.mutate();
		dad.mutate();
		// cross over
		crossOver(babies, mom, dad, parentGen);
		// optimize
		babies.optimize();
	}

	private void optimize() {
		for (Turtle t : this) {
			t.optimize();
		}
	}

	private static void crossOver(Generation babies, Turtle mother,
			Turtle father, Generation parentGen) {
		Turtle.crossOver(babies, mother, father, parentGen);
	}

	public double getAvgFitness() {
		double sum = 0;
		for (Turtle t : this) {
			sum += t.fitness;
		}
		return sum / size();
	}

	@Override
	public String toString() {
		String turtles = "[...";
		for (Turtle t : this) {
			turtles += t.fitness + ", " + t.toString() + " \r\n ";
		}
		turtles += "...]";
		return getAvgFitness() + " :  " + turtles;
	}
}
