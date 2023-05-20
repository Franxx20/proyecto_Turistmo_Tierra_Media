package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Archivo archivo = new Archivo();
		HashMap<String, Atraccion> mapaAtracciones = archivo.leerArchivoAtracciones();
		System.out.println(mapaAtracciones);

		System.out.println("promociones");
		ArrayList<Promocion> promociones = archivo.leerArchivoPromociones(mapaAtracciones);
		System.out.println(promociones);

		System.out.println("Usuarios");
		ArrayList<Usuario> usuarios = archivo.leerArchivoUsuarios();
		System.out.println(usuarios);
	}

}
