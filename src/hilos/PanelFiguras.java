package hilos;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelFiguras extends JPanel {

	ArrayList<Figura> listaFiguras=new ArrayList<Figura>();
	/**
	 * Create the panel.
	 */
	public PanelFiguras() {
	}
	
	public void addFigura(Figura f){
		listaFiguras.add(f);
	}
	
	public void paint(Graphics g){
		for(Figura f:listaFiguras){
			g.setColor(f.getColor());
			String tipoFigura=f.getShape();
			if(tipoFigura.equals("Cuadrado")){
				g.fillRect(f.getX(),f.getY(), f.getSize(), f.getSize());
			}
			else if(tipoFigura.equals("Circulo")){
				g.fillOval(f.getX(),f.getY(), f.getSize(), f.getSize());
			}
			else{
				
			}
		}
	}

}
