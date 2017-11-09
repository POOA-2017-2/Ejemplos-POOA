package juego.manager;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager {

	public ImageManager() {
		// TODO Auto-generated constructor stub
	}
	
	public static BufferedImage cargaImagen(String path){
		try {
			return ImageIO.read(ImageManager.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static BufferedImage subImagen(BufferedImage imagen, int x, int y, int width, int height){
		return imagen.getSubimage(x, y,width, height);
	}

}
