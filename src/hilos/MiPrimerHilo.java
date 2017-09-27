package hilos;

public class MiPrimerHilo extends Thread{

	public void run(){
		synchronized(this){
			if(!isInterrupted())
				for(int i=0;i<10;i++){
					System.out.println(getName()+"-"+i);
				}
		}
	}
}
