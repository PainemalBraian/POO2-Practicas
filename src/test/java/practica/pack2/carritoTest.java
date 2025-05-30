package practica.pack2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class carritoTest {
    @Test
    public void precioTotalTest(){
        TipoDescuento descuento = new DescuentoEstandar();
        TipoProducto producto = new ProductoA("banana",100);

        try {
            CarritoDeCompras carrito = new CarritoDeCompras(descuento);
            carrito.agregarProducto(producto);
            System.out.println(carrito.precioTotal());

            assertEquals(80,carrito.precioTotal());
        } catch (CarritoException e) {
            System.out.println(e);
        }
    }

    @Test
    public void descuentoExceptionTest(){
        var fakeDescuento = new fakeDescuento();

        try {
            CarritoDeCompras carrito = new CarritoDeCompras(fakeDescuento);

        } catch (CarritoException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(),CarritoDeCompras.DESCUENTO_VALIDACION);
        }
    }

}
