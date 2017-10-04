package hilos;

public class MiPrimerHilo extends Thread{

	public void run(){
		for(int i=0;i<10;i++)
			if(!isInterrupted())
				System.out.println(getName()+"-"+i);
		
	}
}
