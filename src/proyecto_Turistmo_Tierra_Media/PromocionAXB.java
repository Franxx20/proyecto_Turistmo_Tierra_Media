package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionAXB extends Promocion {

	@Override
	public String toString() {
		return "PromocionAXB [atracciones=" + atracciones + ", tipoPromocion=" + tipoPromocion + ", duracionTotal="
				+ duracionTotal + ", precioTotal=" + precioTotal + "]";
	}

	public PromocionAXB(ArrayList<Atraccion> atracciones, double duracionTotal, int precioTotal, Tipo tipoPromocion) {
		super(atracciones, duracionTotal, precioTotal, tipoPromocion);
		// TODO Auto-generated constructor stub
	}

}
