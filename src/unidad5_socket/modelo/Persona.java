package unidad5_socket.modelo;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombre;
	private String mensaje;
	
	
	public Persona(String nombre, String mensaje) {
		super();
		this.nombre = nombre;
		this.mensaje = mensaje;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public Persona() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", mensaje=" + mensaje + "]";
	}


	

}
