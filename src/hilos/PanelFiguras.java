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
		repaint();
	}
	
	/*
	 * Método similar a paint,  es el método recomendado para dibujar 
	 * en los componentes JAVA de acuerdo a la documentación para no
	 * generar problemas con las interfaces.
	 * 
	 * */
	public void paintComponent(Graphics g){
		/*
		 * Primero hay que llamar al metodo paintComponent del padre 
		 * de la clase para evitar problemas con los graficos de JAVA.
		 * Por eso usamos la palabra reservada super. 
		 * 
		 **/
		super.paintComponent(g); 
		
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
