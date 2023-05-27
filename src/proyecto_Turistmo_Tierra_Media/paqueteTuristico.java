package proyecto_Turistmo_Tierra_Media;

import java.util.ArrayList;

enum TipoDePaquete {
    AVENTURA, PAISAJE, DEGUSTACION
}
public abstract class paqueteTuristico {
    protected TipoDePaquete tipoDePaquete;
    protected int cuposOcupados;

    protected ArrayList<Atraccion> atracciones;

    public paqueteTuristico(TipoDePaquete tipo){
        this.tipoDePaquete = tipo;
        this.cuposOcupados=0;
    }

    public TipoDePaquete getTipoDePaquete() {
        return tipoDePaquete;
    }

    public int getCuposOcupados() {
        return cuposOcupados;
    }

    public boolean esPromocion(){
        return false;
    }

    public abstract void aumentarCuposOcupados();

    public abstract boolean hayCupo();

}
