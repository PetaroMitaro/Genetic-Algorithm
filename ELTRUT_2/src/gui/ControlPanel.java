package gui;

import genetic.algorithm.LocationList;
import genetic.algorithm.World;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Hashtable;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlPanel extends JPanel implements ActionListener,
		ChangeListener {

	int w = 100, h = 40;
	protected World world = World.getInstance();
	protected static ImageButton reset, play;
	protected static JLabel turtleNumber, genNumber, mutationLabel,
			bestTurtleFitness;
	protected static JCheckBox continuous;
	protected static JSlider mutationRate;
	WorldFrame parentWorldFrame;
	protected static BufferedImage resetPic, pausePic, playPic,
			resetPicPressed, pausePicPressed, playPicPressed;

	public static boolean pauseBetweenTrials;

	public ControlPanel(WorldFrame parentWorldFrame) {
		super();
		this.parentWorldFrame = parentWorldFrame;

		reset = new ImageButton(w, h, resetPic, resetPicPressed, "Reset");
		play = new ImageButton(w, h, playPic, playPicPressed, "Play");

		bestTurtleFitness = new JLabel("Shortest Path: ");
		turtleNumber = new JLabel("turtle: 0");
		genNumber = new JLabel("gen: 0");
		mutationLabel = new JLabel("mut: 0");

		turtleNumber.setPreferredSize(new Dimension(80, 30));
		genNumber.setPreferredSize(new Dimension(60, 30));

		mutationRate = new JSlider(0, 100, 5);
		mutationRate.setValue(20);

		continuous = new JCheckBox();
		continuous.setSelected(true);

		this.add(bestTurtleFitness);
		this.add(reset);
		this.add(mutationRate);
		this.add(mutationLabel);
		this.add(continuous);
		this.add(play);
		this.add(turtleNumber);
		this.add(genNumber);

		reset.addActionListener(this);
		play.addActionListener(this);
		mutationRate.addChangeListener(this);

		int width = Math.max(World.W * Pixel.S, 1100);
		this.setPreferredSize(new Dimension(width, 60));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == play) {
			play.setEnabled(false);
			TurtlePlayer.getInstance().execute();
		} else if (ae.getSource() == reset) {
			play.setEnabled(true);
			World.getInstance().reset();
		}
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
		JSlider source = (JSlider) ce.getSource();
		if (source.equals(mutationRate)) {
			double mut = source.getValue() / 100.0;
			LocationList.chanceOfMutation = mut;
			mutationLabel.setText("mut: " + mut);
		}
	}
}
