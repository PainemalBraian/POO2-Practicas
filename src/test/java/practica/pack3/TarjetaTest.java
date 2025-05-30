package practica.pack3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaTest {

    @Test
    public void tarjetaNoVencidaTest(){
        try {
            TarjetaDeCredito tarjeta = new TarjetaDeCredito("Matias","1234567891234567",123, LocalDate.now().plusDays(60),new FechaReal());
            assertFalse(tarjeta.estaVencida());
            System.out.println("Creado correctamente");
        } catch (TarjetaException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void tarjetaVencidaTest(){
        try {
            var fakeFecha = new FakeFecha(LocalDate.now().plusDays(80));
            TarjetaDeCredito tarjeta = new TarjetaDeCredito("Matias","1234567891234567",123, LocalDate.now().plusDays(60),fakeFecha);

            assertTrue(tarjeta.estaVencida());
            System.out.println("Creado correctamente");
        } catch (TarjetaException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void fechaNoValidaTest(){
        try {
            TarjetaDeCredito tarjeta = new TarjetaDeCredito("Matias","1234567891234567",123, LocalDate.now().minusDays(60),new FechaReal());
            System.out.println("Creado correctamente");
        } catch (TarjetaException e) {
            assertEquals(TarjetaDeCredito.VENCIMIENTO_VALIDACION, e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}
