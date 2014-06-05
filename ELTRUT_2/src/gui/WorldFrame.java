package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WorldFrame extends JFrame {

	private static final WorldFrame theWorldFrame = new WorldFrame();

	public static WorldFrame getInstance() {
		return theWorldFrame;
	}

	public ControlPanel controlPanel;
	private Menu menu;

	private WorldFrame() {
		super();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("World");

		controlPanel = new ControlPanel(this);
		
		menu = new Menu(this);
		this.add(menu, BorderLayout.NORTH);
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(new GridLayout(1, 2));
		fieldPanel.add(TurtleField.getInstance());
		fieldPanel.add(MasterField.getInstance());
		this.add(fieldPanel, BorderLayout.CENTER);
		this.add(controlPanel, BorderLayout.SOUTH);
		this.setResizable(false);
		this.pack();

		this.setVisible(true);
	}

}
