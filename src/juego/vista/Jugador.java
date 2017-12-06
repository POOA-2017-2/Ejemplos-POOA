package juego.vista;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import juego.manager.Animacion;
import juego.manager.Recursos;

public class Jugador {

	private int x;
	private int y;
	private int dx;
	private int dy;
	private ArrayList<Bala> listaBalas;
	private BufferedImage imagen;
	private Juego juego;
	private Animacion jugadorIzquierda;
	private Animacion jugadorDerecha;
	
	public Jugador(Juego juego,int x, int y) {
		super();
		this.juego=juego;
		this.x = x;
		this.y = y;
		dx=1;
		dy=1;
		imagen=Recursos.jugador;
		jugadorIzquierda=new Animacion(100, Recursos.jugadorIzquierda);
		jugadorDerecha=new Animacion(100, Recursos.jugadorDerecha);
		listaBalas=new ArrayList<Bala>();
	}

	public void update(){
		
		if(juego.getPnlJuego().getKm().isDerecha()){
			if(x<=juego.getJuego().getAncho()-150){
				x+=dx;
			}
			jugadorIzquierda.stop();
			jugadorDerecha.start();
		}
		else if(juego.getPnlJuego().getKm().isIzquierda()){
			if(x>=10){
				x-=dx;
			}
			jugadorDerecha.stop();
			jugadorIzquierda.start();
		}
		
		if(juego.getPnlJuego().getKm().isDisparo()){
			String direccion="right";
			if(juego.getPnlJuego().getKm().isIzquierda()){
				direccion="left";
			}
			listaBalas.add(new Bala(x+imagen.getWidth()+2, y+10,direccion));
		}
		
		for(int i=0;i<listaBalas.size();i++){
			listaBalas.get(i).update();
		}
		
	}
	

	public void render(Graphics g){
		g.drawImage(currentFrame(), x, y, null);
		for(int i=0;i<listaBalas.size();i++){
			listaBalas.get(i).render(g);
		}
		//g.dispose();
	}
	
	public BufferedImage currentFrame(){
		if(juego.getPnlJuego().getKm().isDerecha()){
			return jugadorDerecha.currentFrame();
		}
		else if(juego.getPnlJuego().getKm().isIzquierda()){
			return jugadorIzquierda.currentFrame();
		}
		else 
			return Recursos.jugador;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,imagen.getWidth(), imagen.getHeight());
	}
}
