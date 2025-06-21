package tp5TemplateMethodAndComposite.ejercicio1Composite;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SalarioTotalTest {

    @Test
    public void calcularSalarioTotal1(){
        Director director = new Director(100000);
        Gerente gerente = new Gerente(60000);
        MandoMedio mando = new MandoMedio(40000);
        LiderProyecto lider = new LiderProyecto(25000);
        EmpleadoRegular emp1 = new EmpleadoRegular(10000);

        lider.agregarSubordinado(emp1);
        mando.agregarSubordinado(lider);
        gerente.agregarSubordinado(mando);
        director.agregarSubordinado(gerente);

        System.out.println("Salario total de la empresa: " + director.salario());
        assertEquals(235000,director.salario());
    }

    @Test
    public void calcularSalarioTotal2(){
        Director director = new Director(120000);

        Gerente gerente1 = new Gerente(70000);
        Gerente gerente2 = new Gerente(65000);

        MandoMedio mando1 = new MandoMedio(40000);
        LiderProyecto lider1 = new LiderProyecto(30000);
        lider1.agregarSubordinado(new EmpleadoRegular(12000));
        lider1.agregarSubordinado(new EmpleadoRegular(12000));

        mando1.agregarSubordinado(lider1);
        gerente1.agregarSubordinado(mando1);

        MandoMedio mando2 = new MandoMedio(38000);
        LiderProyecto lider2 = new LiderProyecto(28000);
        lider2.agregarSubordinado(new EmpleadoRegular(11000));
        mando2.agregarSubordinado(lider2);
        gerente2.agregarSubordinado(mando2);

        director.agregarSubordinado(gerente1);
        director.agregarSubordinado(gerente2);

        System.out.println("Salario total de la empresa: " + director.salario());
        assertEquals(426000,director.salario());
    }
}
