package juego.vista;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.Timer;

import juego.manager.Estado;
import juego.manager.Recursos;
import juego.paneles.GamePanel;

public class Juego extends Estado {

	private GamePanel pnlJuego;
	private Escenario escenario;
	private Jugador jugador;
	private ArrayList<Enemigo> listaEnemigos;
	private Game juego;
	private BufferStrategy bs;
	private Timer t;
	
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
		listaEnemigos=new ArrayList<Enemigo>();
		listaEnemigos.add(new Enemigo(250, 160));
		listaEnemigos.add(new Enemigo(300, 160));
		listaEnemigos.add(new Enemigo(350, 160));
		
		t=new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listaEnemigos.add(new Enemigo(300, 160));
			}
		});
		
		t.start();
		
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
		for(int i=0; i<listaEnemigos.size();i++){
			listaEnemigos.get(i).render(g);
		}
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
		
	}

	@Override
	public void update() {
		escenario.update();
		jugador.update();
		for(int i=0; i<listaEnemigos.size();i++){
			Enemigo e=listaEnemigos.get(i);
			e.update();
			if(jugador.getBounds().intersects(e.getBounds())){
				listaEnemigos.remove(i);
			}
			
		}
		
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
