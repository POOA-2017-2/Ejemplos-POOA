package juego.vista;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import juego.manager.ImageManager;
import juego.manager.Recursos;

public class Escenario {

	private BufferedImage fondo;
	private BufferedImage piso;
	private BufferedImage piso2;
	private int x;
	private Game game;
	
	public Escenario(Game game) {
		// TODO Auto-generated constructor stub
		this.game=game;
		fondo=Recursos.fondo;
		piso=Recursos.piso;
		piso2=Recursos.piso;
		x=0;
	}
	
	public void update(){
		if(game.getKm().isDerecha()){
			x--;
			//System.out.println(x);
			if(x<=-piso.getWidth()){
				x=0;
			}
		}
		else if(game.getKm().isIzquierda()){
			if(x>=5){
				x++;
			}
			//System.out.println(x);

		}
	}
	
	public void render(Graphics g){
		g.drawImage(fondo, 0, 0, null);

		g.drawImage(piso, x, 0, null);
		g.drawImage(piso2, x+piso.getWidth(), 0, null);
		//g.dispose();
	}

	public BufferedImage getFondo() {
		return fondo;
	}

	public void setFondo(BufferedImage fondo) {
		this.fondo = fondo;
	}

	public BufferedImage getPiso() {
		return piso;
	}

	public void setPiso(BufferedImage piso) {
		this.piso = piso;
	}

	
}
