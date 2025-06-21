package tp7Strategy.ejercicio3;

public class Medicina extends TipoProducto{

    public Medicina(double precio) {
        super(precio);
        super.impuesto = 0;
        if (precio > 50) {
            descuento = 0.1;
        }
        if (precio > 100) {
            envioGratis = true;
        }
    }

}
