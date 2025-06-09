package practica.pack6;

import org.junit.jupiter.api.Test;
import practica.pack6.backend.fake.FakePago;
import practica.pack6.backend.model.PagoConCripto;
import practica.pack6.backend.model.PagoConTarjeta;
import practica.pack6.backend.model.PagoConTransferencia;
import practica.pack6.backend.exception.PagoFallidoException;
import practica.pack6.backend.services.ServicioPagos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class pagosTest {
    @Test
    public void pagoConCripto(){
        var medio = new PagoConCripto();
        var servicio = new ServicioPagos(medio);

        try {
            assertEquals("Pagado $500.0 con CRIPTOMONEDA.", servicio.realizarPago(500));
        } catch (PagoFallidoException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void pagoConTarjeta(){
        var medio = new PagoConTarjeta();
        var servicio = new ServicioPagos(medio);

        try {
            assertEquals("Pagado $500.0 con TARJETA.", servicio.realizarPago(500));
        } catch (PagoFallidoException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void pagoConTransferencia(){
        var medio = new PagoConTransferencia();
        var servicio = new ServicioPagos(medio);

        try {
            assertEquals("Pagado $500.0 con TRANSFERENCIA.", servicio.realizarPago(500));
        } catch (PagoFallidoException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void pagoConFake(){
        var medio = new FakePago();
        var servicio = new ServicioPagos(medio);

        try {
            assertEquals("Pagado $500.0 con Fake.", servicio.realizarPago(500));
        } catch (PagoFallidoException e) {
            System.out.println(e.getMessage());
            assertEquals(ServicioPagos.PAGO_VALIDACION, e.getMessage());
        }
    }

    @Test
    public void pagoExceptionTest(){
        var medio = new FakePago();
        var servicio = new ServicioPagos(medio);

        try {
            assertEquals("Pagado $0.0 con Fake.", servicio.realizarPago(0));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertEquals(ServicioPagos.PAGO_VALIDACION, e.getMessage());
        }
    }

    @Test
    public void pagoExceptionThrowsTest(){
        var medio = new FakePago();
        var servicio = new ServicioPagos(medio);

        assertThrows(PagoFallidoException.class, () -> {
            servicio.realizarPago(-100.0);
        });
    }
}
