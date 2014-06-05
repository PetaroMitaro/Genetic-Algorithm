package genetic.algorithm;

import gui.ResourceLoader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Master {

	private static Master master = new Master();

	public static Master getInstance() {
		return Master.master;
	}

	public LocationList locations;

	private Master() {
		locations = new LocationList();
		loadFromFile();
	}

	private void loadFromFile() {
		URI uri;
		try {
			uri = ResourceLoader.loadData(ResourceLoader.MASTER_FILENAME)
					.toURI();
			File masterFile = new File(uri);
			BufferedReader bfr = new BufferedReader(new FileReader(masterFile));
			String line = "";
			int y = 0;
			while ((line = bfr.readLine()) != null) {
				for (int x = 0; x < World.W && x < line.length(); x++) {
					if (line.charAt(x) == 'X') {
						Location l = new Location(x, y);
						locations.add(l);
					}
				}
				y++;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR " + e.getMessage());
			// for (StackTraceElement ste : e.getStackTrace()) {
			// System.out.println(ste.toString());
			// }
		}
	}
}