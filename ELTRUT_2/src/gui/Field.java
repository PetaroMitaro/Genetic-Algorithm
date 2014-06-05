package gui;

import genetic.algorithm.Location;
import genetic.algorithm.Turtle;
import genetic.algorithm.World;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.PrintStream;
import java.net.URI;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public abstract class Field extends JPanel {

	public static final Color turtlePathColor = new Color(30, 30, 200, 140),
			turtleNoPathColor = new Color(255, 255, 255, 100),
			masterPathColor = new Color(255, 0, 0, 70);
	public static Pixel[][] pixels = new Pixel[World.H][World.W];

	JFrame parentFrame;

	public Field(JFrame parentFrame) {
		super();
		this.parentFrame = parentFrame;
		// init pixels matrix
		for (int x = 0; x < World.W; x++) {
			for (int y = 0; y < World.H; y++) {
				pixels[y][x] = new Pixel(x, y);

			}
		}
		Dimension screenSize = new Dimension(Pixel.S * World.W, Pixel.S
				* World.H);
		this.setPreferredSize(screenSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, World.W * Pixel.S, World.H * Pixel.S);

		for (Pixel[] row : pixels) {
			for (Pixel p : row) {
				// draw current turtle path if on
				if (p.on) {
					g.setColor(Field.turtlePathColor);
					g.fillRect(p.x * Pixel.S, p.y * Pixel.S, Pixel.S, Pixel.S);
				}
				// draw outline unless square is tiny
				if (Pixel.S > 8) {
					g.setColor(Color.gray);
					g.drawRect(p.x * Pixel.S, p.y * Pixel.S, Pixel.S, Pixel.S);
				}
			}
		}

	}
	
	public void save() {
		try {
			URI uri = ResourceLoader.loadData(ResourceLoader.MASTER_FILENAME)
					.toURI();
			PrintStream ps = new PrintStream(new File(uri));
			for (Pixel[] pixelRow : pixels) {
				for (Pixel p : pixelRow) {
					if (p.on) {
						ps.print('X');
					} else {
						ps.print('O');
					}
				}
				ps.println();
			}
			ps.flush();
			ps.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					getClass().getName() + " " + e.getMessage());
		}
	}
}
