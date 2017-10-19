package socket.controlador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import socket.interfaz.Servidor;
import socket.modelo.Persona;

public class ClienteHilo implements Runnable {

	private Socket cliente;
	private Servidor servidor;
	private ObjectInputStream input;
	
	public ClienteHilo(Socket cliente, Servidor servidor) {
		// TODO Auto-generated constructor stub
		this.cliente=cliente;
		this.servidor=servidor;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				input=new ObjectInputStream(cliente.getInputStream());
				Persona p=(Persona) input.readObject();
				servidor.getTxtMensajes().append("\n"+p.getNombre()+": "+p.getMensaje());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
