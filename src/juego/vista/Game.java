package juego.vista;


import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import juego.manager.KeyManager;
import juego.manager.Recursos;

public class Game implements Runnable{

	private Display ventana;
	private int ancho;
	private int alto;
	private String titulo;
	private boolean activo;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private KeyManager km;
	private Escenario escenario;
	private Jugador jugador;
	
	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		km=new KeyManager();
		//init();
	}
	
	public void init(){
		Recursos.init();
		ventana=new Display(ancho, alto, titulo);
		escenario=new Escenario(this);
		jugador=new Jugador(this,10,160);
		ventana.getCanvas().addKeyListener(km);
		ventana.getCanvas().setFocusable(true);
	}

	public synchronized void start(){
		if(activo)
			return;
		
		activo=true;
		t=new Thread(this);
		t.start();
	}
	
	public  synchronized void stop(){
		if(!activo)
			return;
		activo=false;
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void update(){
		escenario.update();
		jugador.update();
	}
	
	public void render(){
		bs=ventana.getCanvas().getBufferStrategy();
		if(bs==null){
			ventana.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g=bs.getDrawGraphics();
		g.clearRect(0, 0, ancho, alto);
		// PINTAR ELEMENTOS
		escenario.render(g);
		jugador.render(g);
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();//<--- INICIALIZAR JUEGO
		int fps=60;
		double nanoPorFrame=1000000000/fps;
		long nuevo;
		long pasado=System.nanoTime();
		double delta=0;
		// variables auxiliares o de testeo
		long time=0;
		int ticks=0;
		
		while(activo){
			
			nuevo=System.nanoTime();
			time+=nuevo-pasado; //<--- testeo  
			delta+=(nuevo-pasado)/nanoPorFrame;
			pasado=nuevo;
			
			if(delta>=1){
				update();// actualizacion logica
				render();// repintado
				delta--;
				ticks++;
			}
			
			// testeo
			if(time>=1000000000){
				System.out.println("Frames por segundo: "+ticks);
				ticks=0;
				time=0;
			}

		}
		
	}

	
	public Escenario getEscenario() {
		return escenario;
	}

	public void setEscenario(Escenario escenario) {
		this.escenario = escenario;
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

	public Graphics getG() {
		return g;
	}

	public void setG(Graphics g) {
		this.g = g;
	}

	public KeyManager getKm() {
		return km;
	}
	
	
	
	


}
