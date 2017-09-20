package hilos;

public class Test {

	public static void main(String[] args) {
		
		MiPrimerHilo hilo1=new MiPrimerHilo();
		hilo1.setName("Maria");
		hilo1.start();
		hilo1.setPriority(Thread.MAX_PRIORITY);
		
		MiPrimerHilo hilo2=new MiPrimerHilo();
		hilo2.setName("Pedro");
		hilo2.start();
		hilo2.setPriority(Thread.MIN_PRIORITY);
		
		MiSegundoHilo hiloRunnable=new MiSegundoHilo("Jose");
		Thread hilo3= new Thread(hiloRunnable);
		hilo3.start();
	}
}
