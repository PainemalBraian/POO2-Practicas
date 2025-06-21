package tp7Strategy.ejercicio3;

public class Libro extends TipoProducto{

    public Libro(double precio) {
        super(precio);
        super.impuesto = 0.1;
        super.descuento = 0.1;
        if (precio>100)
            super.envioGratis = true;
    }

}
