package hilos;

public class MiSegundoHilo implements Runnable {
	private String name;
	
	public MiSegundoHilo(String name){
		this.name=name;
	}
	
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(name+"-"+i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
