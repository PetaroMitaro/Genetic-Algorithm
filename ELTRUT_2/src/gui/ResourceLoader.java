package gui;

import java.io.FileWriter;
import java.net.URL;

import javax.swing.JOptionPane;

final public class ResourceLoader {

	public static final String MASTER_FILENAME = "master.txt";

	public static URL loadImage(String filePath) {
		try {
			return ResourceLoader.class.getResource("/images/" + filePath);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Resource loader error " + e.getMessage());
			return null;
		}
	}

	public static URL loadData(String filePath) {
		try {
			return ResourceLoader.class.getResource("/data/" + filePath);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Resource loader error " + e.getMessage());
			return null;
		}
	}

	public static void writeToLog(String s) {
		try {
			FileWriter fw = new FileWriter("ELTRUT_2_LOG.txt");
			fw.append(s + "\r\n");
			fw.flush();
			fw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage() + " " + e.getCause());
		}
	}
}
