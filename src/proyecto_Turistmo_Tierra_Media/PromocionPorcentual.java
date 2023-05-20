package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

public class PromocionPorcentual extends Promocion {

	@Override
	public String toString() {
		return "PromocionPorcentual [atracciones=" + atracciones + ", tipoPromocion=" + tipoPromocion
				+ ", duracionTotal=" + duracionTotal + ", precioTotal=" + precioTotal + "]";
	}

	public PromocionPorcentual(ArrayList<Atraccion> atracciones, double duracionTotal, int precioTotal,String tipoPromocion) {
		super(atracciones, duracionTotal, precioTotal);
		// TODO Auto-generated constructor stub
	}

}
