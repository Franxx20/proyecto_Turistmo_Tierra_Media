package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class Usuario {
	String nombre;
	TipoDeAtraccion preferencia;
	int presupuesto;
	double tiempoDisponible;
	ArrayList<Atraccion> atraccionesAceptadas;


	public Usuario(String nombre, TipoDeAtraccion preferencia, int presupuesto, double tiempoDisponible,
			ArrayList<Atraccion> atraccionesAceptadas) {
		super();
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.atraccionesAceptadas = atraccionesAceptadas;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempoDisponible=" + tiempoDisponible + ", atraccionesAceptadas=" + atraccionesAceptadas + "]"+ "\n";
	}
	

}
