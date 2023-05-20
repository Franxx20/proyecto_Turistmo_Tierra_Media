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

		return mapaAtracciones;
	}

	public ArrayList<Promocion> leerArchivoPromociones(HashMap<String, Atraccion> mapaAtracciones) {
		Scanner scanner = null;

		ArrayList<Promocion> promociones = new ArrayList<Promocion>();

		try {
			File file = new File("promociones.txt");
			scanner = new Scanner(file);
			// Especifica la configuración regional que se va a utilizar
			scanner.useLocale(Locale.ENGLISH);
			// Para la configuracion regional de Argentina, utilizar:
			// arch.useLocale(new Locale("es_AR"));

			String parseo[];
			String linea = scanner.nextLine();
			parseo = linea.split(",");

			String tipo = parseo[0];
			Tipo preferencia = null;

			switch (tipo) {
			case "ABSOLUTA": {
				int cantAtracciones = Integer.valueOf(parseo[3]);
				double duracionTotal = 0;
				int precioTotal = 0;
				ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

				for (int i = 0; i < cantAtracciones; i++) {
					String nombreAtraccion = parseo[4 + i];
					Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
					duracionTotal += atraccion.getTiempo();
					precioTotal += atraccion.getCosto();
					preferencia = atraccion.getTipo();

					lista_atracciones.add(atraccion);

				}

				Promocion promocion = new PromocionAbsoluta(duracionTotal, precioTotal, lista_atracciones, preferencia);

				promociones.add(promocion);

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipo);
			}

			while (scanner.hasNext()) {
				linea = scanner.nextLine();
				parseo = linea.split(",");

				tipo = parseo[0];

				switch (tipo) {
				case "ABSOLUTA": {
					int cantAtracciones = Integer.valueOf(parseo[3]);
					double duracionTotal = 0;
					int precioTotal = 0;

					ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

					for (int i = 0; i < cantAtracciones; i++) {
						String nombreAtraccion = parseo[4 + i];
						Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
						duracionTotal += atraccion.getTiempo();
						precioTotal += atraccion.getCosto();
						preferencia = atraccion.getTipo();

						lista_atracciones.add(atraccion);

					}

					Promocion promocion = new PromocionAbsoluta(duracionTotal, precioTotal, lista_atracciones,
							preferencia);

					promociones.add(promocion);

					break;
				}
				default:
					throw new IllegalArgumentException("Unexpected value: " + tipo);
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

		return promociones;
	}

	public ArrayList<Usuario> leerArchivoUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
