package juego.vista;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import juego.manager.ImageManager;

public class Jugador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private BufferedImage imagen;
	private Game juego;
	
	public Jugador(Game juego,int x, int y) {
		super();
		this.juego=juego;
		this.x = x;
		this.y = y;
		dx=1;
		dy=1;
		imagen=ImageManager.cargaImagen("/img/logo.png");
	}

	public void update(){
		x+=dx;
		if(x>=juego.getAncho()-imagen.getWidth()){
			dx=-dx;
		}
		
		if(x<=0){
			dx=-dx;
		}
		
	}
	



	public void render(Graphics g){
		g.drawImage(imagen, x, y, null);
		//g.dispose();
	}
}
