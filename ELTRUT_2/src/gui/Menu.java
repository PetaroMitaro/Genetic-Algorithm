package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar implements ActionListener {
	
	JMenu file;
	JMenuItem returnToMain;
	JFrame parent;

	Menu(JFrame parent) {
		super();
		this.parent = parent;
		file = new JMenu("File");
		returnToMain = new JMenuItem("return the main screen");
		file.add(returnToMain);
		this.add(file);
		returnToMain.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == returnToMain) {
			parent.dispose();
			new WelcomeFrame();
		}
	}
}