package juego.vista;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import juego.manager.Estado;
import juego.manager.Recursos;
import juego.paneles.GamePanel;

public class Juego extends Estado {

	private GamePanel pnlJuego;
	private Escenario escenario;
	private Jugador jugador;
	private Game juego;
	private BufferStrategy bs;
	
	public Juego(Game juego) {
		super(EstadoJuego.JUEGO);
		this.juego=juego;
		init();
	}

	@Override
	public void init() {
		Recursos.init();
		pnlJuego=new GamePanel();
		juego.getVentana().getPnlVista().add(pnlJuego,"Juego");// < ---- agregue aqui
		
		
		
		escenario=new Escenario(this);
		jugador=new Jugador(this,10,160);
		
	}

	@Override
	public void render(Graphics g) {
		bs=pnlJuego.getCanvas().getBufferStrategy();
		if(bs==null){
			pnlJuego.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0,juego.getAncho(), juego.getAlto());
		// PINTAR ELEMENTOS
		escenario.render(g);
		jugador.render(g);
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
		
	}

	@Override
	public void update() {
		escenario.update();
		jugador.update();
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		CardLayout c=(CardLayout)juego.getVentana().getPnlVista().getLayout();
		c.show(juego.getVentana().getPnlVista(), "Juego");
		juego.getVentana().setVisible(true);
	}

	public GamePanel getPnlJuego() {
		return pnlJuego;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Game getJuego() {
		return juego;
	}

	
	
}
