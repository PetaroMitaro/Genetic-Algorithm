package genetic.algorithm;

import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class World {

	public static int W = 20, H = 20, GEN_SIZE = 500, GEN_LIM = 500;

	private static final World theWorld = new World();

	public static World getInstance() {
		return theWorld;
	}

	private ArrayList<Generation> generations;
	private Generation currentGen;
	protected int index;

	private World() {
		generations = new ArrayList<Generation>();
		generations.add(new Generation(null));
		currentGen = generations.get(0);
		index = 0;
	}

	public void reset() {
		generations.clear();
		generations.add(new Generation(null));
		currentGen = generations.get(0);
		index = 0;
	}

	public Generation getCurrentGen() {
		currentGen = generations.get(index);
		return this.currentGen;
	}

	public int getIndex() {
		return index;
	}

	public int getSize() {
		return generations.size();
	}

	public void nextGen() {
		// add new gen
		Generation newGen = new Generation(getCurrentGen());
		generations.add(newGen);
		index++;

	}
}
