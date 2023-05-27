package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public abstract class Promocion extends paqueteTuristico{

	protected int precioOriginal;
	protected int precioConDescuento;
	protected double duracionTotal;

	 Promocion(ArrayList<Atraccion> atracciones, double duracionTotal, int precioConDescuento,
			TipoDePaquete tipoPromocion) {
		super(tipoPromocion);
		this.atracciones = atracciones;
		this.duracionTotal = duracionTotal;
		this.precioConDescuento = precioConDescuento;
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


	@Override
	public String toString() {
		return "Promocion [atracciones=" + atracciones + ", tipoPromocion=" + tipoDePaquete + ", duracionTotal="
				+ duracionTotal + ", precioTotal=" + precioConDescuento + "]";
	}


	public boolean hayCupo(){
		for (Atraccion a: this.getAtracciones()){
			if(!a.hayCupo())
				return false;
		}
		return true;
	}

	@Override
	public boolean esPromocion(){
		return true;
	}

	@Override
	public void aumentarCuposOcupados(){
		for(Atraccion a: this.atracciones){
			a.aumentarCuposOcupados();
		}
	}
}
