package practica.pack2;

import java.util.HashMap;
import java.util.Map;

public class CarritoDeCompras {
    static final String DESCUENTO_VALIDACION = "El descuento debe ser mayor o igual a 0";
    private Map<String, Float> productos;
    private TipoDescuento descuento;
    private TipoProducto producto;

    public CarritoDeCompras(TipoDescuento tipoDescuento) throws CarritoException {
        productos = new HashMap<>();
        if (tipoDescuento.descuento() < 0)
            throw new CarritoException(DESCUENTO_VALIDACION);

        this.descuento = tipoDescuento;
    }

    public void agregarProducto(TipoProducto producto) {
        this.productos.put(producto.nombre(), producto.precio());
    }

    public double precioTotal() {
        var totalSinDescuento = this.productos.values().stream()
                .mapToDouble(f -> f.doubleValue()).sum();

        return totalSinDescuento - (totalSinDescuento * this.descuento.descuento());
    }
}