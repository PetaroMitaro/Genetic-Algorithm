package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class CreateMasterFrame extends JFrame {

	private static final CreateMasterFrame theCreateMasterFrame = new CreateMasterFrame();

	public static CreateMasterFrame getInstance() {
		return theCreateMasterFrame;
	}

	private Dimension screenSize;
	private CreateMasterControlPanel controlPanel;
	private Menu menu;

	private CreateMasterFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Master");
		this.setResizable(false);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - WelcomePanel.w) / 2,
				(screenSize.height - WelcomePanel.h) / 2);

		menu = new Menu(this);
		controlPanel = new CreateMasterControlPanel(this);

		this.add(controlPanel, BorderLayout.SOUTH);
		this.add(ClickableField.getInstance(), BorderLayout.CENTER);
		this.add(menu, BorderLayout.NORTH);

		this.pack();
	}
}