package genetic.algorithm;

public class Turtle implements Comparable<Turtle> {

	public LocationList locations;
	public double fitness = 0;
	private int index = 0;

	public Turtle() {
		locations = new LocationList();
	}

	public Location getNextLocation() {
		return locations.get(index + 1);
	}

	public Location getCurrentLocation() {
		return locations.get(index);
	}

	public int getIndex() {
		return index;
	}

	public void calculateFitness() {
		fitness += Location.lengthBetween(getCurrentLocation(),
				getNextLocation());
		nextPath();
	}

	public void nextPath() {
		index++;
	}

	public void fillLocationList() {
		locations.fillFromMaster();
	}

	public boolean done() {
		return index > locations.size() - 2;
	}

	public void mutate() {
		locations.mutate();
	}

	public static void crossOver(Generation babies, Turtle mom, Turtle dad,
			Generation parents) {

		Turtle kid1 = new Turtle();
		Turtle kid2 = new Turtle();

		// split at random point
		int i = mom.locations.size() / 2;

		kid1.locations = mom.locations;// .crossWith(this.locations, i);
		kid2.locations = dad.locations;// .crossWith(mate.locations, i);

		babies.add(kid1);
		babies.add(kid2);
	}

	public void optimize() {
		locations.optimize();
		locations.optimize2();
		// locations.optimize3();
	}

	@Override
	public int compareTo(Turtle t) {
		if (this.fitness < t.fitness) {
			return 1;
		} else if (t.fitness < this.fitness) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public Turtle clone() {
		Turtle t = new Turtle();
		t.locations = this.locations.clone();
		t.fitness = this.fitness;
		return t;

	}

	@Override
	public String toString() {
		return fitness + " " + this.locations.toString();
	}
}
