package unidad2_interfaces;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Mipanel extends JPanel {

	/**
	 * Create the panel.
	 */
	int x=5;
	int y=5;
	public Mipanel() {
		setBorder(new EmptyBorder(10, 10, 10, 9));
		setBackground(new Color(0, 128, 128));
	}
	
	public void paintComponent(final Graphics g){
		g.setColor(Color.black);
		g.fillRect(x, y, 100, 100);
		repaint();
	}

}

