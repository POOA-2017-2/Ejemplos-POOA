package juego.elementos;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import juego.manager.Recursos;

public class Enemigo {

	private int x;
	private int y;
	private int dx;
	private BufferedImage imagen;
	
	public Enemigo(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		dx=2;
		imagen=Recursos.enemigo;
	}

	public void update(){
		// INCREMENTAMOS LA COORDENADA X DEL ENEMIGO, ENEMIGO TIENE UN COMPORTAMIENTO "TONTO".
		x-=dx;
	}
	
	public void render(Graphics g){
		// DIBUJAMOS AL ENEMIGO
		g.drawImage(imagen,x,y,null);
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
	
	// METODO PARA RETORNAR UN RECTANGULO CON LAS DIMENSIONES DEL ENEMIGO, PARA LAS COLISIONES.
	public Rectangle getBounds(){
		return new Rectangle(x,y,imagen.getWidth(), imagen.getHeight());
	}

}
