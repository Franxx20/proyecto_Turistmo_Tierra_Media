package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	@Override
	public String toString() {
		return "PromocionAbsoluta [precioConDescuento=" + precioConDescuento + ", atracciones=" + atracciones
				+ ", tipoPromocion=" + tipoPromocion + ", duracionTotal=" + duracionTotal + ", precioTotal="
				+ precioTotal + "]";
	}

	private int precioConDescuento ;

	//ABSOLUTA,AVENTURA,30,Mordor,Moria

	public PromocionAbsoluta( double duracionTotal, int precioTotal,ArrayList<Atraccion> atracciones,Tipo tipoPromocion) {
		super(atracciones, duracionTotal, precioTotal, tipoPromocion);
		// TODO Auto-generated constructor stub
	}

	public int getPrecioConDescuento() {
		return precioConDescuento;
	}

	public void setPrecioConDescuento(int precioConDescuento) {
		this.precioConDescuento = precioConDescuento;
	}
}
