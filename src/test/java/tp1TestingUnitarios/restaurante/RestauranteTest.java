package tp1TestingUnitarios.restaurante;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    @Test
    public void calcularCostoConTarjetaVisa() {
        // Configuración
        Comensal cliente = new Comensal(11111111,"Juan Pérez");
        TarjetaCredito tarjetaVisa = new TarjetaCredito("Juan Pérez", "1234567890123456", "12/25", "Visa", 123);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Coca Cola", "Bebida gaseosa", 100.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 2); // Pedido de 2 bebidas
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaVisa,3);

        // Verificar el pago con descuento del 3% en bebidas
        assertEquals(199.82, mesa.obtenerTotalConDescuento(tarjetaVisa, 3));// Propina del 3%
    }

    @Test
    public void calcularCostoConTarjetaMastercard() {
        // Configuración
        TarjetaCredito tarjetaMastercard = new TarjetaCredito("María López", "9876543210987654", "06/27", "Mastercard", 456);
        Mesa mesa = new Mesa(4);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Pizza", "Pizza de muzzarella", 300.0, 10);
        mesa.addProducto(plato);
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaMastercard,5);

        // Verificar el pago con descuento del 2% en platos
        mesa.pagarPedido(tarjetaMastercard, 5); // Propina del 5%
        assertEquals(308.7, mesa.obtenerTotalConDescuento(tarjetaMastercard, 5));
    }

    @Test
    public void calcularCostoConTarjetaComarcaPlus() {
        // Configuración
        TarjetaCredito tarjetaComarcaPlus = new TarjetaCredito("Ana Gómez", "1111222233334444", "03/28", "Comarca Plus", 789);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Agua", "Agua mineral", 50.0, 10);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Hamburguesa", "Hamburguesa con queso", 200.0, 10);
        mesa.addProducto(bebida);
        mesa.addProducto(plato);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaComarcaPlus,2);

        // Verificar el pago con descuento del 2% total
        mesa.pagarPedido(tarjetaComarcaPlus, 2); // Propina del 2%
        assertEquals(249.9, mesa.obtenerTotalConDescuento(tarjetaComarcaPlus, 2));
        //assertTrue(mesa.seConfirmoPedido());
    }

    @Test
    public void calcularCostoConTarjetaNoReconocida() {
        // Configuración
        TarjetaCredito tarjetaViedma = new TarjetaCredito("Carlos Díaz", "5555666677778888", "07/30", "Viedma", 321);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Jugo", "Jugo de naranja", 120.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaViedma,5);

        // Verificar que no aplica descuento
        mesa.pagarPedido(tarjetaViedma, 5); // Propina del 5%
        assertEquals(125.0, mesa.obtenerTotalConDescuento(tarjetaViedma, 5));
        assertTrue(mesa.seConfirmoPedido());

    }
}


//    Luego de implementar escriba los siguientes casos de test:
//    1.Cálculo de costo con tarjeta Visa.
//    2. Cálculo de costo con tarjeta Mastercard.
//    3. Cálculo de costo con tarjeta Comarca Plus.
//    4. Cálculo de costo con tarjeta Viedma.
//    Lograr alta cobertura (mayor a 90%).
//    Verifique si quedan funcionalidades sin testear.