package gui;

import genetic.algorithm.World;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CreateMasterControlPanel extends JPanel implements ActionListener,
		ItemListener, ChangeListener {

	int w = 100, h = 40;
	ImageButton save;
	CreateMasterFrame parentFrame;
	public static BufferedImage resetPic, nextPic, pausePic, playPic,
			resetPicPressed, nextPicPressed, pausePicPressed, playPicPressed;

	public static boolean pauseBetweenTrials;

	public CreateMasterControlPanel(CreateMasterFrame parentFrame) {
		super();
		this.parentFrame = parentFrame;
		save = new ImageButton(w, h, resetPic, resetPicPressed, "Save");
		this.add(save);
		save.addActionListener(this);
		this.setPreferredSize(new Dimension((World.W + 2) * Pixel.S, 60));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == save) {
			// save field
			ClickableField.getInstance().save();
		}
	}

	@Override
	public void stateChanged(ChangeEvent ce) {
	}

	@Override
	public void itemStateChanged(ItemEvent ie) {
	}
}
