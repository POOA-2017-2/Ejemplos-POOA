package unidad3_serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TestSerializacion {

	public static void main(String[] args) {
		
		Persona juan=new Persona("Juan",20,Genero.HOMBRE);
		Persona maria=new Persona("Maria",20,Genero.MUJER);
		Persona pedro=new Persona("Pedro",20,Genero.HOMBRE);
		ArrayList<Persona> lista=new ArrayList<Persona>();
		lista.add(juan);
		lista.add(maria);
		lista.add(pedro);

		try {
			FileOutputStream file= new FileOutputStream("test.txt");
			ObjectOutputStream oos= new ObjectOutputStream(file);
			oos.writeObject(lista);

			file.close();
			oos.close();
			System.out.println("hola");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		try {
			FileInputStream file= new FileInputStream("test.txt");
			ObjectInputStream ois=new ObjectInputStream(file);
			ArrayList<Persona> leida=(ArrayList<Persona>) ois.readObject();
			for(Persona p:leida){
				System.out.println(p.toString());
			}
			file.close();
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		
	}

}
