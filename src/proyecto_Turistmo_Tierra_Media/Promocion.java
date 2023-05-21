package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public abstract class Promocion {

	protected ArrayList<Atraccion> atracciones;
	protected TipoDeAtraccion preferenciaPromocion;
	protected int precioOriginal;
	protected int precioConDescuento;
	protected double duracionTotal;

	public Promocion(ArrayList<Atraccion> atracciones, double duracionTotal, int precioConDescuento,
			TipoDeAtraccion tipoPromocion) {
		this.atracciones = atracciones;
		this.duracionTotal = duracionTotal;
		this.precioConDescuento = precioConDescuento;
		this.preferenciaPromocion = tipoPromocion;
	}

	public ArrayList<Atraccion> getAtracciones() {
		return atracciones;
	}

	public double getDuracionTotal() {
		return duracionTotal;
	}

	public int getPrecioConDescuento() {
		return precioConDescuento;
	}

	public int getPrecioOriginal() {
		return precioOriginal;
	}

	public TipoDeAtraccion getTipoDeAtraccionPromocion() {
		return preferenciaPromocion;
	}

	public void setAtracciones(ArrayList<Atraccion> atracciones) {
		this.atracciones = atracciones;
	}

	public void setDuracionTotal(double duracionTotal) {
		this.duracionTotal = duracionTotal;
	}

	public void setPrecioConDescuento(int precioConDescuento) {
		this.precioConDescuento = precioConDescuento;
	}

	public void setPrecioOriginal(int precioOriginal) {
		this.precioOriginal = precioOriginal;
	}

	public void setTipoDeAtraccionPromocion(TipoDeAtraccion tipoPromocion) {
		this.preferenciaPromocion = tipoPromocion;
	}

	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", tipoPromocion=" + preferenciaPromocion + ", duracionTotal="
				+ duracionTotal + ", precioTotal=" + precioConDescuento + "]";
	}

}
