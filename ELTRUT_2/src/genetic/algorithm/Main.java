package genetic.algorithm;

import gui.ImageButton;
import gui.ResourceLoader;
import gui.WelcomeFrame;
import gui.WelcomePanel;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {

		loadPics();

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new WelcomeFrame();
			}
		});
	}

	public static void loadPics() {
		try {
			// images
			ImageButton.exitImg = ImageIO.read(ResourceLoader
					.loadImage("exit.png"));
			ImageButton.exitImgPressed = ImageIO.read(ResourceLoader
					.loadImage("exitPressed.png"));
			ImageButton.settingsImg = ImageIO.read(ResourceLoader
					.loadImage("settings.png"));
			ImageButton.settingsImgPressed = ImageIO.read(ResourceLoader
					.loadImage("settingsPressed.png"));
			WelcomePanel.welcomeBackground = ImageIO.read(ResourceLoader
					.loadImage("background.jpg"));
			ImageButton.buttonImg = ImageIO.read(ResourceLoader
					.loadImage("buttonBackground.png"));
			ImageButton.buttonImgPressed = ImageIO.read(ResourceLoader
					.loadImage("buttonBackground.png"));

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					e.getMessage() + " " + e.getCause());
		}
	}

}
