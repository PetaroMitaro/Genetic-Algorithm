package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class ClickableField extends Field implements MouseListener {

	private static final ClickableField theClickableField = new ClickableField();

	public static ClickableField getInstance() {
		return theClickableField;
	}

	private ClickableField() {
		super(CreateMasterFrame.getInstance());
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		int nearestX = Math.round(me.getX() / Pixel.S);
		int nearestY = Math.round(me.getY() / Pixel.S);
		Pixel p = Field.pixels[nearestY][nearestX];
		p.on = !p.on;
		super.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent me) {
	}

	@Override
	public void mouseExited(MouseEvent me) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}
