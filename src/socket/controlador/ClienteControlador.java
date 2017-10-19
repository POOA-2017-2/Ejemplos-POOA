package socket.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import socket.interfaz.Cliente;
import socket.modelo.Persona;

public class ClienteControlador implements ActionListener{

	private Cliente cliente;
	private Socket puente;
	
	public ClienteControlador(Cliente cliente, Socket puente) {
		this.cliente=cliente;
		this.puente=puente;
	}

	public void actionPerformed(ActionEvent e) {
		//String host="127.0.0.1";
		//int port=8000;
		try {
			//Socket s=new Socket(host, port);
			ObjectOutputStream salida=new ObjectOutputStream(puente.getOutputStream());
			String nombre=cliente.getTxtNombre().getText();
			String mensaje=cliente.getTxtMensaje().getText();
			Persona p=new Persona(nombre, mensaje);
			//DataOutputStream salida=new DataOutputStream(s.getOutputStream());
			//String mensaje=cliente.getTxtMensaje().getText();
			//salida.writeUTF(mensaje);
			salida.writeObject(p);	
			cliente.getTxtMensaje().setText("");
			cliente.getTxtMensajes().append("\n Yo:"+mensaje);
			
			//salida.close();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
