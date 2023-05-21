package proyecto_Turistmo_Tierra_Media;

enum TipoDeAtraccion {
	AVENTURA, PAISAJE, DEGUSTACION
}

public class Atraccion {
	String nombre;
	int costo;
	double tiempo;
	int cupo;
	TipoDeAtraccion tipo;

	public Atraccion(String nombre, TipoDeAtraccion tipo, int costo, double tiempo, int cupo) {
		super();
		this.nombre = nombre;
		this.costo = costo;
		this.tiempo = tiempo;
		this.cupo = cupo;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "\nAtraccion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupo
				+ ", tipo=" + tipo + "]" + "\n";
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

	public TipoDeAtraccion getTipoDeAtraccion() {
		return tipo;
	}

	public void setTipoDeAtraccion(TipoDeAtraccion tipo) {
		this.tipo = tipo;
	}

}
