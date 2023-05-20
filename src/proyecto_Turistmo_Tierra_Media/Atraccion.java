package proyecto_Turistmo_Tierra_Media;

enum Tipo {
	AVENTURA, PAISAJE, DEGUSTACION
}

public class Atraccion {
	String nombre;
	int costo;
	double tiempo;
	int cupo;
	Tipo preferencia;

	public Atraccion(String nombre,Tipo tipo, int costo, double tiempo, int cupo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.preferencia = tipo;
	}

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo + ", tipo="
				+ preferencia + "]" + "\n";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCosto() {
		return costo;
	}

	public void setCosto(int costo) {
		this.costo = costo;
	}

	public double getTiempo() {
		return tiempo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo = tiempo;
	}

	public int getCupo() {
		return cupo;
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public Tipo getTipo() {
		return preferencia;
	}

	public void setTipo(Tipo tipo) {
		this.preferencia = tipo;
	}


}
