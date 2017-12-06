package juego.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import juego.manager.Recursos;

public class Bala {

	private int x;
	private int y;
	private int dx;
	private String direccion;
	
	public Bala(int x, int y, String direccion) {
		super();
		this.x = x;
		this.y = y;
		this.direccion=direccion;
		dx=2;
	}


	public void update(){
		if(direccion.equals("right"))
			x+=dx;
		else if(direccion.equals("left"))
			x-=dx;
	}
	
	public void render(Graphics g){
		g.setColor(Color.red.darker());
		g.fillRect(x, y, 2, 2);
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
		return new Rectangle(x,y,2,2);
	}

}
