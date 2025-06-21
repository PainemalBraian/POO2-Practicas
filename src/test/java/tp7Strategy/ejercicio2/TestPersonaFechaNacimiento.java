package tp7Strategy.ejercicio2;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class TestPersonaFechaNacimiento {

    @Test
    public void testFormatoCorto() {
        LocalDate fechaEjemplo = LocalDate.of(1986, 6, 3);
        Persona persona = new Persona(fechaEjemplo, new fechaCorta());

        String fechaFormateada = persona.fechaNacimiento();

        System.out.println(fechaFormateada);
        assertEquals("03/06/1986", fechaFormateada);
    }

    @Test
    public void testFormatoLargo() {
        LocalDate fechaEjemplo = LocalDate.of(1986, 6, 3);
        Persona persona = new Persona(fechaEjemplo, new fechaLarga());

        String fechaFormateada = persona.fechaNacimiento();

        System.out.println(fechaFormateada);
        assertEquals("3 de junio de 1986", fechaFormateada);
    }

}
