package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MeasurePathFrame extends JFrame {

	private static final MeasurePathFrame theMeasurePathFrame = new MeasurePathFrame();

	public static MeasurePathFrame getInstance() {
		return theMeasurePathFrame;
	}

	private Dimension screenSize;
	private CreateMasterControlPanel controlPanel;
	public JLabel lengthLabel;
	private Menu menu;

	private MeasurePathFrame() {
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Create Master");
		this.setResizable(false);
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - WelcomePanel.w) / 2,
				(screenSize.height - WelcomePanel.h) / 2);

		menu = new Menu(this);
		lengthLabel = new JLabel("Len: 0.0");
		this.add(lengthLabel, BorderLayout.SOUTH);
		this.add(MeasurePathField.getInstance(), BorderLayout.CENTER);
		this.add(menu, BorderLayout.NORTH);

		this.pack();
	}

	public void start() {
		setVisible(true);
		MeasurePathField.getInstance().paths.clear();
	}
}