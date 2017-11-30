package juego.vista;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import juego.paneles.GamePanel;

public class Display extends JFrame{

	private int ancho;
	private int alto;
	private String titulo;
	private JPanel pnlVista;
	
	public Display(int ancho, int alto, String titulo) throws HeadlessException {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		init();
	}

	public void init(){
		setSize(ancho, alto);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(titulo);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0,0)); //<--- ESTABLECEMOS NUEVO LAYOUT
		
		pnlVista=new JPanel();
		pnlVista.setLayout(new CardLayout(0,0));
		getContentPane().add(pnlVista, BorderLayout.CENTER); // <---- ME FALTO
		
		
		//pack(); //<--- AJUSTA TAMANO DE LA PANTALLA, PARA QUE TODOS LOS ELEMENTOS SEAN VISIBLES. 
		//setVisible(true); //<--- AL FINAL SIEMPRE, SI NO LO PONEN AL FINAL MOSTRARA UNA VENTANA VACIA UN TIEMPO, HASTA QUE TERMINE DE CONSTRUIRSE LA VENTANA.
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public JPanel getPnlVista() {
		return pnlVista;
	}
	
	
	
}
