package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class WelcomeFrame extends JFrame {

	WelcomePanel welcomePanel;
	Dimension screenSize;

	public WelcomeFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("******** WELCOME********");
		this.setResizable(false);
		this.setUndecorated(true);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - WelcomePanel.w) / 2,
				(screenSize.height - WelcomePanel.h) / 2);

		welcomePanel = new WelcomePanel(this);
		this.add(welcomePanel);
		this.pack();

		this.setVisible(true);

	}
}