package serializacion;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombre;
	private  int edad;
	private Genero genero;
	
	
	public Persona(String nombre, int edad, Genero genero) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.genero = genero;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}


	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", edad=" + edad + ", genero=" + genero + "]";
	}
	
	


}
