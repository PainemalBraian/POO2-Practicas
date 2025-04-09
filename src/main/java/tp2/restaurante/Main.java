package tp2.restaurante;
import tp2.restaurante.persistance.AlmacenamientoBaseDatosRestaurante;

public class Main {
    public static void main(String[] args) {
        // Usar base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosRestaurante();

        // Configurar Mesa
        Comensal cliente = new Comensal(11111111, "Juan Pérez");
        TarjetaCredito tarjetaVisa = new TarjetaCredito("Juan Pérez", "1234567890123456", "12/25", "Visa", 123);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Coca Cola", "Bebida gaseosa", 100.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 2); // Pedido de 2 bebidas

        // Registrar pedido
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaVisa,3);
        almacenamientoBaseDatos.guardarDetalle(mesa.generarDetallePago(tarjetaVisa,3));
    }
}
