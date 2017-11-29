package juego.paneles;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import juego.manager.KeyManager;

public class GamePanel extends JPanel{

	private Canvas canvas;
	private KeyManager km;
	
	public GamePanel() {
		// TODO Auto-generated constructor stub
		init();
	}

	public void init(){
		
		setLayout(new BorderLayout(0,0));
		canvas=new Canvas();
		canvas.setSize(300, 250);
		add(canvas,BorderLayout.CENTER); // <--- AGREGAMOS EL CANVAS AL CENTRO DEL CONTENTPANE
		
		
		JPanel panelBotones=new JPanel(); //<-- PANEL PARA INCLUIR BOTONES/
		
		JButton btnLeft =new JButton("<---");
		panelBotones.add(btnLeft);
		
		
		JButton btnRight=new JButton("-->");
		panelBotones.add(btnRight);
		
		
		add(panelBotones,BorderLayout.SOUTH); //<--- AGREGAMOS AL SUR DEL CONTENTPANE EL PANEL QUE CONTIENE BOTONES
		
		km=new KeyManager();
		canvas.addKeyListener(km); // agregue esto
		canvas.setFocusable(true); // agregue esto
		//addKeyListener(km);
		//setFocusable(true);
		

		setVisible(true);
		//add(canvas);
	}
	
	public Canvas getCanvas() {
		return canvas;
	}

	public void setCanvas(Canvas canvas) {
		this.canvas = canvas;
	}

	public KeyManager getKm() {
		return km;
	}
	
	
}
