package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class Usuario {
	private final String nombre;
	private final TipoDePaquete preferencia;
	private final int presupuesto;
	private final double tiempoDisponible;
	private final ArrayList<Atraccion> itinerario;


	public Usuario(String nombre, TipoDePaquete preferencia, int presupuesto, double tiempoDisponible,
			ArrayList<Atraccion> itinerario) {
		super();
		this.nombre = nombre;
		this.preferencia = preferencia;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.itinerario = itinerario;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", preferencia=" + preferencia + ", presupuesto=" + presupuesto
				+ ", tiempoDisponible=" + tiempoDisponible + ", itinerario=" + itinerario + "]"+ "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public TipoDePaquete getPreferencia() {
		return preferencia;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public ArrayList<Atraccion> getItinerario() {
		return itinerario;
	}

	public void agregarAItinerario(Atraccion atraccion){
		this.itinerario.add(atraccion);
	}
}
