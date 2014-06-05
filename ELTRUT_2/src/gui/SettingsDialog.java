package gui;

import genetic.algorithm.LocationList;
import genetic.algorithm.World;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SettingsDialog extends JDialog implements ActionListener {

	JPanel p;
	JLabel genSizeLabel, genLimLabel, gridWLabel, gridHLabel, opt1RateLabel,
			opt2RateLabel;
	JTextField genSize, genLim, gridW, gridH, opt1Rate, opt2Rate;
	JButton save;

	SettingsDialog() {
		super();

		genSizeLabel = new JLabel("Generation Size");
		genLimLabel = new JLabel("Generation Lim");
		gridWLabel = new JLabel("Grid Width");
		gridHLabel = new JLabel("Grid Height");
		opt1RateLabel = new JLabel("Rate of Linear Optimization");
		opt2RateLabel = new JLabel("Initial Population Greedyness");

		genSize = new JTextField("500");
		genLim = new JTextField("500");
		gridW = new JTextField("20");
		gridH = new JTextField("20");
		opt1Rate = new JTextField("0.6");
		opt2Rate = new JTextField("0.2");

		save = new JButton("Save");
		save.addActionListener(this);

		p = new JPanel();
		p.setLayout(new BorderLayout());

		JPanel subPanel = new JPanel();
		subPanel.setLayout(new GridLayout(6, 2));
		subPanel.add(genSizeLabel);
		subPanel.add(genSize);
		subPanel.add(genLimLabel);
		subPanel.add(genLim);
		subPanel.add(gridWLabel);
		subPanel.add(gridW);
		subPanel.add(gridHLabel);
		subPanel.add(gridH);
		subPanel.add(opt1RateLabel);
		subPanel.add(opt1Rate);
		subPanel.add(opt2RateLabel);
		subPanel.add(opt2Rate);

		p.add(subPanel, BorderLayout.CENTER);
		p.add(save, BorderLayout.SOUTH);
		p.setPreferredSize(new Dimension(400, 200));

		this.setResizable(false);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screenSize.width - 200) / 2,
				(screenSize.height - 100) / 2);
		// this.setUndecorated(true);
		this.add(p);
		this.pack();
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == save) {
			try {
				World.GEN_LIM = Integer.parseInt(genLim.getText());
				World.GEN_SIZE = Integer.parseInt(genSize.getText());
				World.W = Integer.parseInt(gridW.getText());
				World.H = Integer.parseInt(gridH.getText());
				LocationList.chanceOfOpt2 = Double
						.parseDouble(opt1Rate.getText());
				LocationList.chanceOfNeighborPreference = Double
						.parseDouble(opt2Rate.getText());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "You must enter integers!");
			}
		}
	}
}
