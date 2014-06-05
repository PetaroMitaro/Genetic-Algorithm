package genetic.algorithm;

public class Location implements Comparable<Location> {

	public int x, y;
	public LocationList nearbyLocations;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void setNearbyLocations() {
		for (Location l : Master.getInstance().locations) {
			if (Location.lengthBetween(l, this) < 6) {
				l.nearbyLocations.add(l);
			}
		}
	}

	public boolean invalid() {
		return x >= World.W || x < 0 || y < 0 || y >= World.H;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	public static double lengthBetween(Location l, Location last) {
		double dx = last.x - l.x;
		double dy = last.y - l.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public boolean isNextTo(Location a) {
		return Math.abs(a.x - x) <= 1 || Math.abs(a.y - y) <= 1;
	}

	@Override
	public Location clone() {
		Location newLoc = new Location(this.x, this.y);
		return newLoc;
	}

	@Override
	public int compareTo(Location loc) {
		return x == loc.x && y == loc.y ? 0 : 1;
	}

}
