package tp5TemplateMethodAndComposite.ejercicio5TemplateMethod;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RemeraTest {
    @Test
    public void calcularRemeraImportada(){
        Remera remera = new RemeraImportada(1000);

        assertEquals(1080,remera.calcularPrecio());
    }
    @Test
    public void calcularRemeraNacional(){
        Remera remera = new RemeraNacional(1000);

        assertEquals(815,remera.calcularPrecio());
    }
}
