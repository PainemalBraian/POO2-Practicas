package tp7Strategy.ejercicio3;

public abstract class TipoProducto {
    double precio;
    double impuesto = 0.15;
    double descuento = 0;
    boolean envioGratis = false;

    public TipoProducto(double precio) {
        this.precio = precio;

        if (precio > 50) {
            descuento = 0.05;
        }
        if (precio > 200) {
            envioGratis = true;
        }
    }

    double precio(){
        return precio;
    }
    double impuesto(){
        return impuesto;
    }
    double descuento(){
        return descuento;
    }
    boolean envioGratis(){
        return envioGratis;
    }
}
