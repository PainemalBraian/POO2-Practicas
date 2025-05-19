package tp5.ejercicio1;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalarioTotalTest {

    @Test
    public void calcularSalarioTotal1() throws IOException {
        // Crear empleados regulares (sin subordinados)
        Categoria empleado1 = new EmpleadoRegular("Empleado Regular", 1000);
        Categoria empleado2 = new EmpleadoRegular("Empleado Regular", 1200);

        // Crear líder de proyecto y agregar empleados
        Categoria lider = new EmpleadoComposite("Líder de Proyecto", 2000);
        lider.agregarSubordinado(empleado1);
        lider.agregarSubordinado(empleado2);

        // Crear mando medio y agregar líder
        Categoria mandoMedio = new EmpleadoComposite("Mando Medio", 3000);
        mandoMedio.agregarSubordinado(lider);

        // Crear gerente y agregar mando medio
        Categoria gerente = new EmpleadoComposite("Gerente", 5000);
        gerente.agregarSubordinado(mandoMedio);

        // Crear director y agregar gerente
        Categoria director = new EmpleadoComposite("Director", 8000);
        director.agregarSubordinado(gerente);

        //asserts
        assertEquals(20200,director.calcularSalarioTotal());
    }

    @Test
    public void calcularSalarioTotal2() throws IOException {
        // Crear empleados regulares (sin subordinados)
        Categoria empleado1 = new EmpleadoRegular("Empleado Regular", 500);

        // Crear líder de proyecto y agregar empleados
        Categoria lider = new EmpleadoComposite("Líder de Proyecto", 2800);
        lider.agregarSubordinado(empleado1);

        // Crear mando medio y agregar líder
        Categoria mandoMedio = new EmpleadoComposite("Mando Medio", 5000);
        mandoMedio.agregarSubordinado(lider);

        // Crear gerente y agregar mando medio
        Categoria gerente = new EmpleadoComposite("Gerente", 9000);
        gerente.agregarSubordinado(mandoMedio);

        // Crear director y agregar gerente
        Categoria director = new EmpleadoComposite("Director", 15000);
        director.agregarSubordinado(gerente);

        //asserts
        assertEquals(32300,director.calcularSalarioTotal());
    }
}
