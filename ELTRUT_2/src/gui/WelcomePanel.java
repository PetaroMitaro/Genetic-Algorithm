package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class WelcomePanel extends JPanel implements ActionListener {

	Dimension screenSize;
	static int w = 960, h = 600;
	public static BufferedImage welcomeBackground;
	public static ImageButton createMaster, runWorld, measurePath, settings,
			exit;
	WelcomeFrame parent;

	public WelcomePanel(WelcomeFrame parent) {
		super();

		this.parent = parent;
		this.setPreferredSize(new Dimension(w, h));
		exit = new ImageButton(40, 40, ImageButton.exitImg,
				ImageButton.exitImgPressed, "");
		settings = new ImageButton(40, 40, ImageButton.settingsImg,
				ImageButton.settingsImgPressed, "Settings");
		createMaster = new ImageButton(400, 80, null, null, "Create Master");
		measurePath = new ImageButton(400, 80, null, null, "Measure Path");
		runWorld = new ImageButton(400, 80, null, null, "Run World");
		this.add(exit);
		this.add(createMaster);
		this.add(measurePath);
		this.add(runWorld);
		this.add(settings);
		exit.addActionListener(this);
		createMaster.addActionListener(this);
		measurePath.addActionListener(this);
		settings.addActionListener(this);
		runWorld.addActionListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		exit.setLocation(w - 40 - 2, 2);
		createMaster.setLocation((w - 400) / 2, 200);
		measurePath.setLocation((w - 400) / 2, 300);
		runWorld.setLocation((w - 400) / 2, 400);
		settings.setLocation(20, h - 60);
		g.drawImage(welcomeBackground, 0, 0, w, h, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			System.exit(1);
		} else if (e.getSource() == createMaster) {
			CreateMasterFrame.getInstance().setVisible(true);
			parent.dispose();
		} else if (e.getSource() == measurePath) {
			MeasurePathFrame.getInstance().start();
			parent.dispose();
		} else if (e.getSource() == runWorld) {
			WorldFrame.getInstance().setVisible(true);
			parent.dispose();
		} else if (e.getSource() == settings) {
			// open settings pop-up
			new SettingsDialog();
		}
	}

}
