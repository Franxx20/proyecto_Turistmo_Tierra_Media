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
      // File file = new File("atracciones.txt");
      File file = new File("../../casos de prueba/in/atracciones.txt");
      scanner = new Scanner(file);
      // Especifica la configuración regional que se va a utilizar
      scanner.useLocale(Locale.ENGLISH);
      // Para la configuracion regional de Argentina, utilizar:
      // arch.useLocale(new Locale("es_AR"));

      while (scanner.hasNext()) {
        String linea = scanner.nextLine();
        String[] datos = linea.split(",");

        String nombre = datos[0];

        TipoDeAtraccion tipo = TipoDeAtraccion.valueOf(datos[1]);
        int costo = Integer.valueOf((datos[2]));
        double tiempo = Double.valueOf(datos[3]);
        int cupo = Integer.valueOf(datos[4]);

        Atraccion atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
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
      // File file = new File("promociones.txt");
      File file = new File("../../casos de prueba/in/promociones.txt");
      scanner = new Scanner(file);
      // Especifica la configuración regional que se va a utilizar
      scanner.useLocale(Locale.ENGLISH);

      while (scanner.hasNext()) {
        String linea = scanner.nextLine();
        String[] parseo = linea.split(",");

        String tipo = parseo[0];
        TipoDeAtraccion preferencia = null;

        switch (tipo) {
          case "ABSOLUTA": {
            int cantAtracciones = Integer.valueOf(parseo[3]);
            double duracionTotal = 0;
            int precioTotalOriginal = 0;
            int precioConDescuento = Integer.valueOf(parseo[2]);
            ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

            for (int i = 0; i < cantAtracciones; i++) {
              String nombreAtraccion = parseo[4 + i];
              Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
              duracionTotal += atraccion.getTiempo();
              precioTotalOriginal += atraccion.getCosto();
              preferencia = atraccion.getTipoDeAtraccion();

              lista_atracciones.add(atraccion);

            }

            Promocion promocion = new PromocionAbsoluta(duracionTotal, precioConDescuento, lista_atracciones,
                preferencia);
            promocion.setPrecioOriginal(precioTotalOriginal);

            promociones.add(promocion);

            break;
          }
          case "AXB": {
            int cantAtracciones = Integer.valueOf(parseo[3]);
            int precioTotalOriginal = 0;
            int precioConDescuento = Integer.valueOf(parseo[2]);
            double duracionTotal = 0;
            ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

            for (int i = 0; i < cantAtracciones; i++) {
              String nombreAtraccion = parseo[4 + i];
              Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
              duracionTotal += atraccion.getTiempo();
              precioTotalOriginal += atraccion.getCosto();
              preferencia = atraccion.getTipoDeAtraccion();
              lista_atracciones.add(atraccion);
            }

            Promocion promocion = new PromocionAXB(duracionTotal, precioConDescuento, lista_atracciones,
                preferencia);
            promocion.setPrecioOriginal(precioTotalOriginal);

            promociones.add(promocion);

            break;
          }
          case "PORCENTUAL": {
            int cantAtracciones = Integer.valueOf(parseo[3]);
            int precioTotalOriginal = 0;
            int precioConDescuento = 0;
            int porcentajeDescuento = 100 - Integer.valueOf(parseo[2]);
            double duracionTotal = 0;
            ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

            for (int i = 0; i < cantAtracciones; i++) {
              String nombreAtraccion = parseo[4 + i];
              Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
              duracionTotal += atraccion.getTiempo();
              precioTotalOriginal += atraccion.getCosto();
              preferencia = atraccion.getTipoDeAtraccion();
              lista_atracciones.add(atraccion);
            }

            precioConDescuento = (porcentajeDescuento * precioTotalOriginal) / 100;
            Promocion promocion = new PromocionPorcentual(duracionTotal, precioConDescuento, lista_atracciones,
                preferencia);
            promocion.setPrecioOriginal(precioTotalOriginal);

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
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    Scanner scanner = null;

    try {
      // File file = new File("usuarios.txt");
      File file = new File("../../casos de prueba/in/usuarios.txt");
      scanner = new Scanner(file);

      scanner.useLocale(Locale.ENGLISH);

      while (scanner.hasNext()) {

        String linea = scanner.nextLine();
        String[] parseo = linea.split(",");

        TipoDeAtraccion preferencia = TipoDeAtraccion.valueOf(parseo[0]);
        String nombre = parseo[1];
        int presupuesto = Integer.valueOf(parseo[2]);
        double tiempoDisponible = Double.valueOf(parseo[2]);
        ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();

        Usuario usuario = new Usuario(nombre, preferencia, presupuesto, tiempoDisponible, atraccionesAceptadas);

        usuarios.add(usuario);
      }

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    } finally {
      scanner.close();
    }

    return usuarios;
  }

}
