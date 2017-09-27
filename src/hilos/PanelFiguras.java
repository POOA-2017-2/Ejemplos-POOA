package hilos;


import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PanelFiguras extends JPanel{

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
				Polygon p=new Polygon();
				p.addPoint(f.getX()+(f.getSize()/2), f.getY()-f.getSize());
				p.addPoint(f.getX(), f.getY());
				p.addPoint(f.getX()+f.getSize(), f.getY());
		
				g.fillPolygon(p);
			}
		}
	}


	
	/*
	public void run() {
		while(true){
			for(Figura f: listaFiguras)
				f.mover(getHeight(), getWidth());
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	*/

	
	
}
