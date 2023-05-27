package proyecto_Turistmo_Tierra_Media;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

public class Archivo {

    public HashMap<String, Atraccion> leerArchivoAtracciones() {

        HashMap<String, Atraccion> mapaAtracciones = new HashMap<String, Atraccion>();

        File file = null;
        try {
            file = new File(
                    "proyecto_Turistmo_Tierra_Media/casos de prueba/in/atracciones.txt");
            System.out.println(file.getAbsoluteFile());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        try (Scanner scanner = new Scanner(file)) {
            scanner.useLocale(Locale.ENGLISH);
            parseoAtracciones(scanner, mapaAtracciones);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return mapaAtracciones;
    }

    private static void parseoAtracciones(Scanner scanner, HashMap<String, Atraccion> mapaAtracciones) {
        while (scanner.hasNext()) {
            String linea = scanner.nextLine();
            String[] datos = linea.split(",");

            String nombre = datos[0];

            TipoDePaquete tipo = TipoDePaquete.valueOf(datos[1]);
            int costo = Integer.valueOf((datos[2]));
            double tiempo = Double.valueOf(datos[3]);
            int cupo = Integer.valueOf(datos[4]);

            Atraccion atraccion = new Atraccion(nombre, tipo, costo, tiempo, cupo);
            mapaAtracciones.put(nombre, atraccion);
        }
    }

    public ArrayList<Promocion> leerArchivoPromociones(HashMap<String, Atraccion> mapaAtracciones) {

        ArrayList<Promocion> promociones = new ArrayList<Promocion>();

        try (Scanner scanner = new Scanner(new File("proyecto_Turistmo_Tierra_Media/casos de prueba/in/promociones.txt"))) {
            scanner.useLocale(Locale.ENGLISH);
            parseoPromociones(mapaAtracciones, scanner, promociones);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return promociones;
    }

    private static void parseoPromociones(HashMap<String, Atraccion> mapaAtracciones, Scanner scanner,
                                          ArrayList<Promocion> promociones) {
        while (scanner.hasNext()) {
            String linea = scanner.nextLine();
            String[] parseo = linea.split(",");

            String tipo = parseo[0];
            TipoDePaquete preferencia = null;
            double duracionTotal =0;
            int precioTotalOriginal =0;
            int precioConDescuento =0;

            switch (tipo) {
                case "ABSOLUTA": {
                    int cantAtracciones = Integer.valueOf(parseo[3]);
                    precioConDescuento = Integer.valueOf(parseo[2]);
                    ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

                    for (int i = 0; i < cantAtracciones; i++) {
                        String nombreAtraccion = parseo[4 + i];
                        Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
                        duracionTotal += atraccion.getTiempo();
                        precioTotalOriginal += atraccion.getCosto();
                        preferencia = atraccion.getTipoDePaquete();

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
                    precioConDescuento = Integer.valueOf(parseo[2]);
                    ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

                    for (int i = 0; i < cantAtracciones; i++) {
                        String nombreAtraccion = parseo[4 + i];
                        Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
                        duracionTotal += atraccion.getTiempo();
                        precioTotalOriginal += atraccion.getCosto();
                        preferencia = atraccion.getTipoDePaquete();
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
                    int porcentajeDescuento = 100 - Integer.valueOf(parseo[2]);
                    ArrayList<Atraccion> lista_atracciones = new ArrayList<Atraccion>();

                    for (int i = 0; i < cantAtracciones; i++) {
                        String nombreAtraccion = parseo[4 + i];
                        Atraccion atraccion = mapaAtracciones.get(nombreAtraccion);
                        duracionTotal += atraccion.getTiempo();
                        precioTotalOriginal += atraccion.getCosto();
                        preferencia = atraccion.getTipoDePaquete();
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
    }

    public ArrayList<Usuario> leerArchivoUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        try (Scanner scanner = new Scanner(new File("proyecto_Turistmo_Tierra_Media/casos de prueba/in/usuarios.txt"))) {
            scanner.useLocale(Locale.ENGLISH);
            parseoUsuarios(usuarios, scanner);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    private static void parseoUsuarios(ArrayList<Usuario> usuarios, Scanner scanner) {
        while (scanner.hasNext()) {

            String linea = scanner.nextLine();
            String[] parseo = linea.split(",");

            TipoDePaquete preferencia = TipoDePaquete.valueOf(parseo[0]);
            String nombre = parseo[1];
            int presupuesto = Integer.valueOf(parseo[2]);
            double tiempoDisponible = Double.valueOf(parseo[2]);
            ArrayList<Atraccion> atraccionesAceptadas = new ArrayList<Atraccion>();

            Usuario usuario = new Usuario(nombre, preferencia, presupuesto, tiempoDisponible, atraccionesAceptadas);

            usuarios.add(usuario);
        }
    }

}
