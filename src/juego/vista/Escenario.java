package juego.vista;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import juego.manager.ImageManager;

public class Escenario {

	private BufferedImage fondo;
	private BufferedImage piso;
	
	public Escenario() {
		// TODO Auto-generated constructor stub
		fondo=ImageManager.cargaImagen("/img/country-platform-back.png");
		piso=ImageManager.cargaImagen("/img/country-platform-tiles-example.png");
	}
	
	public void update(){

	}
	
	public void render(Graphics g){
		g.drawImage(fondo, 0, 0, null);

		g.drawImage(piso, 0, 0, null);
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
