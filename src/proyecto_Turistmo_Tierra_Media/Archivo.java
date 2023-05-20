package proyecto_Turistmo_Tierra_Media;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {


	public ArrayList<Promocion> leerArchivoPromociones() {
		Scanner scanner = null;

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		try {
			File file = new File("promociones.txt");
			scanner = new Scanner(file);
			// Especifica la configuración regional que se va a utilizar
			scanner.useLocale(Locale.ENGLISH);
			// Para la configuracion regional de Argentina, utilizar:
			// arch.useLocale(new Locale("es_AR"));

			String datos[];
			String linea = scanner.nextLine();
			datos = linea.split(",");

			System.out.println(linea);

			String tipo = datos[0];

//			ArrayList<Atraccion>  atracciones = new ArrayList<Atraccion>();
//			switch (tipo) {
//			case "ABSOLUTA": {
//
//				atracciones.add(new Atraccion());
//
//				Promocion promocion = new PromocionAbsoluta(Double.valueOf(datos[2],Integer.valueOf(datos[3]));
//				
//				yield type;
//			}
//			default:
//				throw new IllegalArgumentException("Unexpected value: " + tipo);
//			}

			while (scanner.hasNext()) {
				linea = scanner.nextLine();
				datos = linea.split(",");
				System.out.println(linea);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return promociones;
	}

	public HashMap<String, Atraccion> leerArchivoAtracciones() {

		Scanner scanner = null;
		HashMap<String, Atraccion> mapaAtracciones = new HashMap<String, Atraccion>();

		try {
			File file = new File("atracciones.txt");
			scanner = new Scanner(file);
			// Especifica la configuración regional que se va a utilizar
			scanner.useLocale(Locale.ENGLISH);
			// Para la configuracion regional de Argentina, utilizar:
			// arch.useLocale(new Locale("es_AR"));

			String datos[];
			String linea = scanner.nextLine();
			datos = linea.split(",");

			String nombre = datos[0];
			Tipo tipo = Tipo.valueOf(datos[1]);
			int costo = Integer.valueOf((datos[2]));
			double tiempo = Double.valueOf(datos[3]);
			int cupo = Integer.valueOf(datos[4]);

			Atraccion atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
			mapaAtracciones.put(nombre, atraccion);

			while (scanner.hasNext()) {
				linea = scanner.nextLine();
				datos = linea.split(",");

				nombre = datos[0];

				tipo = Tipo.valueOf(datos[1]);
				costo = Integer.valueOf((datos[2]));
				tiempo = Double.valueOf(datos[3]);
				cupo = Integer.valueOf(datos[4]);

				atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
				mapaAtracciones.put(nombre, atraccion);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		
		System.out.println(mapaAtracciones);

		return mapaAtracciones;
	}

}
