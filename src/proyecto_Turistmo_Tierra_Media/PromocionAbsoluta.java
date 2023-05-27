package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionAbsoluta extends Promocion {

	@Override
	public String toString() {
		return "PromocionAbsoluta [" + "tipoPromocion=" + tipoDePaquete + ", precioConDescuento="
				+ precioConDescuento + ", precioOriginal=" + precioOriginal + ", duracionTotal=" + duracionTotal
				+ ", atracciones=" + atracciones + "]" + "\n";
	}

	// ABSOLUTA,AVENTURA,30,Mordor,Moria

	public PromocionAbsoluta(double duracionTotal, int precioConDescuento, ArrayList<Atraccion> atracciones,
			TipoDePaquete tipoPromocion) {
		super(atracciones, duracionTotal, precioConDescuento, tipoPromocion);
	}

}
