package tp1.restaurante;

public class Producto {
    static String STOCK_NO_DISPONIBLE = "Este producto no cuenta con el stock solicitado";
    static int idProducto=0;
    private int id;
    private TipoProducto tipo; // Uso de Enum para Plato o bebida
    private String nombre;
    private String descripcion;
    private double costo;
    private int stock;

    public enum TipoProducto {
        PLATO, BEBIDA
    }

    public String verProducto() {
        String detalle = "Tipo de producto: " + tipo + "\n"
                + "Nombre: " + nombre + "\n"
                + "Descripción: " + descripcion + "\n"
                + "Precio: $" + String.format("%.2f", costo);
        return detalle;
    }

    public boolean disminuirStock(int cantidad) {
        if (stock >= cantidad){
            stock -= cantidad;
            return true;}
        else throw new RuntimeException(STOCK_NO_DISPONIBLE);
    }



}

//    Los comensales una vez ubicados en una mesa, utilizan un dispositivo electrónico donde pueden navegar un menú que contiene bebidas y platos principales con su precio.