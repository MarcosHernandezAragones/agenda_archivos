package IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Ejercicio.Persona;

public class IODatos {

		public static void mostrar(String nombreFichero, int longitudLinea) {
			File f = new File(nombreFichero);
			FileReader fr = null;
			Scanner leer = null;
			if (!f.exists()) {
				try {
					f.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

			try {
				fr = new FileReader(f);
				leer = new Scanner(fr);
				while (leer.hasNext()) {
					String linea = leer.nextLine();
					// tratamos las lineas
					formatearLinea(linea,longitudLinea);
				}
			} catch (Exception e) { 
				e.printStackTrace();
			} finally {
				try {
					leer.close();
					fr.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		

		
		

		private static void formatearLinea(String linea, int longitudLinea) {
			Persona p;
			String nombre="", apellido="", aux;
			int nip;
			nip = Integer.parseInt(linea.substring(0, 6));
			aux = linea.substring(7);
			
			for(int i=0;i<aux.length();i++) {
				if(aux.substring(i,i+1).equals(",")) {
					apellido=aux.substring(0,i);
					nombre = aux.substring(i+2);
					
				}
			}
			p = new Persona(nombre, apellido, nip);
			System.out.println(p.mostrar(longitudLinea));
			
		}

}
