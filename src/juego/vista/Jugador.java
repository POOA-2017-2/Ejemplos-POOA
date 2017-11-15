package juego.vista;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import juego.manager.Animacion;
import juego.manager.ImageManager;
import juego.manager.Recursos;

public class Jugador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private BufferedImage imagen;
	private Game juego;
	private Animacion jugadorIzquierda;
	private Animacion jugadorDerecha;
	
	public Jugador(Game juego,int x, int y) {
		super();
		this.juego=juego;
		this.x = x;
		this.y = y;
		dx=1;
		dy=1;
		imagen=Recursos.jugador;
		jugadorIzquierda=new Animacion(100, Recursos.jugadorIzquierda);
		jugadorDerecha=new Animacion(100, Recursos.jugadorDerecha);
	}

	public void update(){
		
		if(juego.getKm().isDerecha()){
			if(x<=juego.getAncho()-150){
				x+=dx;
			}
			jugadorIzquierda.stop();
			jugadorDerecha.start();
		}
		else if(juego.getKm().isIzquierda()){
			if(x>=10){
				x-=dx;
			}
			jugadorDerecha.stop();
			jugadorIzquierda.start();
		}
		
	}
	

	public void render(Graphics g){
		g.drawImage(currentFrame(), x, y, null);
		//g.dispose();
	}
	
	public BufferedImage currentFrame(){
		if(juego.getKm().isDerecha()){
			return jugadorDerecha.currentFrame();
		}
		else if(juego.getKm().isIzquierda()){
			return jugadorIzquierda.currentFrame();
		}
		else 
			return Recursos.jugador;
	}
}