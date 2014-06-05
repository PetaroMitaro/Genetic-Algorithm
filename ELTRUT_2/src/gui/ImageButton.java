package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class ImageButton extends JButton {

	private static final long serialVersionUID = 6316886668679040393L;
	public int w, h;
	public static BufferedImage buttonImg, buttonImgPressed, settingsImg,
			settingsImgPressed, exitImg, exitImgPressed;
	public BufferedImage img, imgPressed;
	Font buttonFont;

	ImageButton(int w, int h, BufferedImage img, BufferedImage imgPressed,
			String label) {
		super(label);
		this.w = w;
		this.h = h;
		if (img == null || imgPressed == null) {
			this.img = ImageButton.buttonImg;
			this.imgPressed = ImageButton.buttonImgPressed;
		} else {
			this.img = img;
			this.imgPressed = imgPressed;
		}
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		buttonFont = new Font("", Font.BOLD, 20);
		this.setPreferredSize(new Dimension(w, h));
		this.setHorizontalTextPosition(SwingConstants.CENTER);
		this.setVerticalTextPosition(SwingConstants.CENTER);
		this.setForeground(Color.black);
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black));
		this.setFont(buttonFont);
	}

	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isPressed()) {
			g.drawImage(imgPressed, 0, 0, w, h, this);
		} else {
			g.drawImage(img, 0, 0, w, h, this);
		}
		super.paintComponent(g);
	}

}
