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
			int xBala=x+imagen.getWidth()+2; // COORDENADA X DE LA BALA
		    int yBala=y+10; // COORDENADA Y DE LA BALA
			if(juego.getPnlJuego().getKm().isIzquierda()){
				direccion="left";
				xBala=x-2; // COORDENADA X DE LA BALA SI ES POR EL LADO IZQUIERDO
			}
			listaBalas.add(new Bala(xBala, yBala,direccion));
			juego.getPnlJuego().getKm().setDisparo(false);
		}
		
		for(int i=0;i<listaBalas.size();i++){ // RECORREMOS LAS BALAS EXISTENTES
			
			Bala item= listaBalas.get(i);
			item.update(); // ACTUALIZAMOS POSICION DE LA BALA
			
			if(item.getX()<0 || item.getX()>320){ // SE PREGUNTA SI LA BALA ESTA FUERA DE RANGO DEL JUEGO
				
				/*
				 * NOTA: Los ArrayList tienen el metodo remove para eliminar elementos, este metodo esta sobrecargado.
				 * Primera opcion= remove(int index) ---> Remueve el elemento en el indice especificado.
				 * Segunda opcion= remove(Object item) ---> Remueve un OBJETO si existe en el arreglo, si hay mas de dos objetos iguales remueve al primero
				 * 											que encuentra.
				 * 
				 * EL METODO UPDATE PUEDE CAUSAR PROBLEMAS AL ESTAR LLAMANDOSE 60 VECES POR SEGUNDO, PUEDE PASAR QUE QUIERAN
				 * ELIMINAR OBJETOS QUE YA NO EXISTEN, Y NO PUEDEN APRECIARLO EN EL JUEGO YA QUE AL USAR LA ESTRATEGIA BufferStrategy
				 * ESTAN OBSERVANDO UN FRAME ANTIGUO MIENTRAS LOS NUEVOS ESTAN EN LA COLA DE FRAMES. 
				 * POR ESTE MOTIVO ES MEJOR USAR LA SEGUNDA OPCION PARA REMOVER OBJETOS YA QUE VALIDA SI EXISTE O NO, SI EXISTE LO REMUEVE
				 * SI NO EXISTE NO HACE NADA, EVITAMOS EXCEPCIONES DE INTENTAR ELIMINAR ALGO QUE YA NO EXISTE.
				 * 
				 * 
				 * */
				listaBalas.remove(item); // SI ESTA SE REMUEVE LA BALA.
			}
			
			for(int j=0;j<juego.getListaEnemigos().size();j++){ // RECORRE  LA LISTA DE ENEMIGOS
				
				Enemigo enemigo=juego.getListaEnemigos().get(j); // OBTENEMOS EL ENEMIGO ACTUAL
				
				if (item.getBounds().intersects(enemigo.getBounds())){  // CHECAMOS SI EL ENEMIGO CHOCA CON NUESTRA BALA
					 juego.getListaEnemigos().remove(enemigo); // SI CHOCA REMOVEMOS AL ENEMIGO
					 listaBalas.remove(item); // SI CHOCA REMOVEMOS LA BALA
				}
				
			}
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
