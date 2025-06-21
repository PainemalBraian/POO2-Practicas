package tp7Strategy.ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaEnviosTest {

    @Test
    public void testColectivosSur() {
        var sistema = new SistemaCompras();
        sistema.agregarProducto(new Producto("Pantalla", 200000, 10));
        sistema.agregarProducto(new Producto("MotherBoard", 100000, 1));
        sistema.seleccionarFormaEnvio(new ColectivosSurStrategy());

        assertEquals(1500, sistema.obtenerCostoEnvio("Capital Federal"));
        assertEquals(301500, sistema.calcularCostoTotal("Capital Federal"));
    }

    @Test
    public void testCorreoArgentino() {
        var sistema = new SistemaCompras();
        sistema.agregarProducto(new Producto("Impresora", 80000, 8));

        sistema.seleccionarFormaEnvio(new CorreoArgentinoStrategy());
        assertEquals(500, sistema.obtenerCostoEnvio("Capital Federal"));
    }
}