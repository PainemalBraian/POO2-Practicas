package practica.pack2;

public class ProductoA implements TipoProducto{
    String nombre;
    Float precio;

    public ProductoA(String nombre, float precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public Float precio() {
        return precio;
    }
}
