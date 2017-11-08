package juego.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable{

	private Display ventana;
	private int ancho;
	private int alto;
	private String titulo;
	private boolean activo;
	private Thread t;
	private BufferStrategy bs;
	private Graphics g;
	private int x=0; 
	
	public Game(int ancho, int alto, String titulo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.titulo = titulo;
		//init();
	}
	
	public void init(){
		ventana=new Display(ancho, alto, titulo);
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
		x++;
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
		g.setColor(Color.red);
		g.fillRect(x, 20, 30, 40);
		// FIN DEL PINTADO
		bs.show();
		g.dispose();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		init();//<--- INICIALIZAR JUEGO
		int fps=120;
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
	


}
