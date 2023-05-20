package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public abstract class Promocion {

	ArrayList<Atraccion> atracciones;
	String tipoPromocion;

	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", tipoPromocion=" + tipoPromocion + ", duracionTotal="
				+ duracionTotal + ", precioTotal=" + precioTotal + "]";
	}

	public Promocion( ArrayList<Atraccion> atracciones, double duracionTotal, int precioTotal ) {
		this.atracciones = atracciones;
		this.duracionTotal = duracionTotal;
		this.precioTotal = precioTotal;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}
	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}
	public String getTipoPromocion() {
		return tipoPromocion;
	}
	public void setTipoPromocion(String tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}
	public double getDuracionTotal() {
		return duracionTotal;
	}
	public void setDuracionTotal(double duracionTotal) {
		this.duracionTotal = duracionTotal;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}

	double duracionTotal;
	int precioTotal;

}
