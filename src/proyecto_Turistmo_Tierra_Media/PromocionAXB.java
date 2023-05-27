package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionAXB extends Promocion {

	@Override
	public String toString() {
		return "PromocionAXB [" + "tipoPromocion=" + tipoDePaquete + ", precioConDescuento="
				+ precioConDescuento + ", precioOriginal=" + precioOriginal + ", duracionTotal=" + duracionTotal
				+ ", atracciones=" + atracciones + "]" + "\n";
	}

	public PromocionAXB(double duracionTotal, int precioConDescuento, ArrayList<Atraccion> atracciones,
			TipoDePaquete tipoPromocion) {
		super(atracciones, duracionTotal, precioConDescuento, tipoPromocion);
	}

}
