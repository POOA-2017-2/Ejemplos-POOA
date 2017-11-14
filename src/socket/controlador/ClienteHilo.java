package socket.controlador;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import socket.interfaz.Servidor;
import socket.modelo.Persona;

public class ClienteHilo implements Runnable {

	private Socket cliente;
	private Servidor servidor;
	private ObjectInputStream input;
	private ArrayList<Socket> listaClientes;
	
	public ClienteHilo(Socket cliente, Servidor servidor, ArrayList<Socket> listaClientes) {
		// TODO Auto-generated constructor stub
		this.cliente=cliente;
		this.servidor=servidor;
		this.listaClientes=listaClientes;
	}

	@Override
	public void run() {
		
		while(true){
			try {
				input=new ObjectInputStream(cliente.getInputStream());
				Persona p=(Persona) input.readObject();
				servidor.getTxtMensajes().append("\n"+p.getNombre()+": "+p.getMensaje());
				for(Socket item:listaClientes){
					if(!item.equals(cliente)){
						ObjectOutputStream output=new ObjectOutputStream(item.getOutputStream());
						output.writeObject(p);
					}
				}
				
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
