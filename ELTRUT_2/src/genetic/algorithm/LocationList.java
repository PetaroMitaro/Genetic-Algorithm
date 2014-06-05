package genetic.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class LocationList extends ArrayList<Location> {

	public static double chanceOfMutation = 0.15, chanceOfOpt2 = 0.4,
			chanceOfNeighborPreference = 0.8;
	private static final Random R = new Random();
	private static final LocationList masterList = Master.getInstance().locations;

	public LocationList() {
		super();
	}

	public void shuffle() {
		Collections.shuffle(this);
	}

	public void fillFromMaster() {
		for (Location l : masterList) {
			add(l);
		}
		Collections.shuffle(this);
	}

	public void mutate() {
		// randomly flip locations
		for (int i = 0; i < size() - 1; i++) {
			if (R.nextDouble() < LocationList.chanceOfMutation) {
				Collections.swap(this, i, i + 1);
			}
		}
	}

	public LocationList crossWith(LocationList mateList, int crossPoint) {
		return this;
	}

	public void optimize() {
		for (int i = 0; i < this.size() - 4; i++) {
			Location A = this.get(i);
			Location B = this.get(i + 1);
			Location C = this.get(i + 2);
			Location D = this.get(i + 3);

			double option1 = Location.lengthBetween(A, B)
					+ Location.lengthBetween(C, D);
			double option2 = Location.lengthBetween(A, C)
					+ Location.lengthBetween(B, D);

			// if the second choice is better, make the flip
			if (option2 < option1) {
				this.remove(i + 1);
				this.remove(i + 1);
				this.add(i + 1, C);
				this.add(i + 2, B);
			}
		}
	}

	public void optimize2() {
		for (int i = 0; i < size() - 1; i++) {
			Location A = this.get(i);
			// find closest locations
			Location closestLoc = locationClosestTo(A);
			if (closestLoc != null) {
				if (R.nextDouble() < chanceOfOpt2 || A.isNextTo(closestLoc)) {
					Collections.swap(this, i + 1, this.indexOf(closestLoc));
				}
			}
		}
	}

	public void optimize3() {
		for (int i = 0; i < size() - 4; i += 2) {

			Location A = this.get(i).clone();
			Location B = this.get(i + 1).clone();

			for (int j = i + 2; j < size() - 2; j += 2) {
				Location C = this.get(j).clone();
				Location D = this.get(j + 1).clone();

				double option1 = Location.lengthBetween(A, B)
						+ Location.lengthBetween(C, D);
				double option2 = Location.lengthBetween(A, D)
						+ Location.lengthBetween(C, B);

				// if the second choice is better, make the flip
				if (option2 < option1) {
					get(i + 1).x = D.x;
					get(i + 1).y = D.y;
					get(j + 1).x = B.x;
					get(j + 1).y = B.y;
				}
			}
		}

	}

	private Location locationClosestTo(Location A) {
		Location B = null;
		double min = Double.MAX_VALUE;
		for (Location loc : this) {
			double len = Location.lengthBetween(A, loc);
			if (loc.x != A.x || loc.y != A.y) {
				if (len < min) {
					min = len;
					B = loc;
				}
			}
		}
		return B;
	}

	@Override
	public String toString() {
		String str = "";
		for (Location l : this) {
			str += "[" + l.toString() + "] ";
		}
		return str;
	}

	public LocationList sub(LocationList list, int start, int end) {
		LocationList sub = new LocationList();
		for (int i = start; i < end; i++) {
			sub.add(list.get(i));
		}
		return sub;
	}

	@Override
	public LocationList clone() {
		LocationList newList = new LocationList();
		for (Location l : this) {
			newList.add(l.clone());
		}
		return newList;
	}
}