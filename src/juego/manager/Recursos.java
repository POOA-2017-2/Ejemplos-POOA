package juego.manager;

import java.awt.image.BufferedImage;

public class Recursos {

	public static BufferedImage fondo;
	public static BufferedImage piso;
	public static BufferedImage jugador;
	public static BufferedImage[] jugadorIzquierda;
	public static BufferedImage[] jugadorDerecha;
	
	
	public static void init(){
		fondo=ImageManager.cargaImagen("/img/country-platform-back.png");
		piso=ImageManager.cargaImagen("/img/country-platform-tiles-example.png");
		
		SpriteManager sm=new SpriteManager("/img/test.png");
		jugador=sm.subImagen(0, 0, 32, 32);
		
		jugadorIzquierda=new BufferedImage[3];
		jugadorDerecha=new BufferedImage[3];
		
		jugadorIzquierda[0]=sm.subImagen(0, 32, 32, 32);
		jugadorIzquierda[1]=sm.subImagen(32, 32, 32, 32);
		jugadorIzquierda[2]=sm.subImagen(64, 32, 32, 32);
		
		jugadorDerecha[0]=sm.subImagen(0, 64, 32, 32);
		jugadorDerecha[1]=sm.subImagen(32, 64, 32, 32);
		jugadorDerecha[2]=sm.subImagen(64, 64, 32, 32);
	
	}

}
