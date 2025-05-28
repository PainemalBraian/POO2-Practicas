package tp5TemplateMethodAndComposite.ejercicio4TemplateMethod;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadorTest {

    @Test
    public void calcularJubilados(){
        Calculador c = new CalculadorJubilado(new ConsolaLogTransaction(), LocalDate.now().getMonth().getValue());
        assertEquals(2000,c.calcularPrecio(2000));
    }

    @Test
    public void calcularNOJubilados(){
        Calculador c = new CalculadorNoJubilado(new ConsolaLogTransaction(),LocalDate.now().getMonth().getValue());
        assertEquals(1150,c.calcularPrecio(1000));
    }
}
