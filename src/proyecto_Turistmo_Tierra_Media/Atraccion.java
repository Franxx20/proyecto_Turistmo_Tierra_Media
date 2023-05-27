package proyecto_Turistmo_Tierra_Media;


public class Atraccion extends paqueteTuristico {
    String nombre;
    int costo;
    double tiempo;
    int cupoMaximo;

    public Atraccion(String nombre, TipoDePaquete tipo, int costo, double tiempo, int cupoMaximo) {
        super(tipo);
        this.nombre = nombre;
        this.costo = costo;
        this.tiempo = tiempo;
        this.cupoMaximo = cupoMaximo;
    }

    @Override
    public String toString() {
        return "\nAtraccion [nombre=" + nombre + ", costo=" + costo + ", tiempo=" + tiempo + ", cupo=" + cupoMaximo
                + ", tipo=" + this.tipoDePaquete+ "]" + "\n";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public TipoDePaquete getTipoDePaquete() {
        return tipoDePaquete;
    }

    public void setTipoDeAtraccion(TipoDePaquete tipo) {
        this.tipoDePaquete = tipo;
    }


    @Override
    public boolean hayCupo() {
        return this.getCupoMaximo() > 0;
    }


    @Override
    public void aumentarCuposOcupados() {
        this.cuposOcupados+=1;
    }

}
