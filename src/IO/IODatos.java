package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Ejercicio.Persona;

public class IODatos {

	public static void mostrar(String nombreFichero, int longitudLinea) {

		// ---------------------------------------------------------------------Crear
		// archivo
		File f = new File(nombreFichero);

		FileReader fr = null;
		Scanner leer = null;

		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// ---------------------------------------------------------------------fin crear archivo
		// ---------------------------------------------------------------------Leer
		try {

			fr = new FileReader(f);
			leer = new Scanner(fr);
			
			
			while (leer.hasNext()) {
				String linea = leer.nextLine();
				//Tratar las lineas
				formatearLinea(linea, longitudLinea);
			}
		// ----------------------------------------------------------------------Fin leer
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} finally {
			
			leer.close();
			
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

	private static void formatearLinea(String linea,int longitudLinea) {
		Persona p;
		String nombre="", apellido="",aux;
		int nip;
		nip =Integer.parseInt(linea.substring(0, 6));
		//sacar nombre y apellidos
		aux=linea.substring(7);
		
		for (int i = 0; i < aux.length(); i++) {
			
			//buscar la ,
			if (aux.substring(i).equalsIgnoreCase(",")) {
				apellido=aux.substring(8,i);
				nombre=aux.substring(i+2);
			}
			
			
		}
		
		p= new Persona(nombre,apellido,nip);
		System.out.println(p);
	}

}
