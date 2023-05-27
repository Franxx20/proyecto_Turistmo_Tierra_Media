package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {
	@Override
	public String toString() {
		return "PromocionPorcentual [" + "tipoPromocion=" + tipoDePaquete + ", precioConDescuento="
				+ precioConDescuento + ", precioOriginal=" + precioOriginal + ", duracionTotal=" + duracionTotal
				+ ", atracciones=" + atracciones + "]" + "\n";
	}

	public PromocionPorcentual(double duracionTotal, int precioConDescuento, ArrayList<Atraccion> atracciones,
			TipoDePaquete tipoPromocion) {
		super(atracciones, duracionTotal, precioConDescuento, tipoPromocion);
	}

}
