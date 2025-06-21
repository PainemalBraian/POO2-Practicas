package tp7Strategy.ejercicio3;

public class Alimento extends TipoProducto{

    public Alimento(double precio) {
        super(precio);
        super.impuesto = 0.05;
        if (precio > 100) {
            super.descuento = 0.15;
        }
        if (precio > 200) {
            super.envioGratis = true;
        }
    }

}
