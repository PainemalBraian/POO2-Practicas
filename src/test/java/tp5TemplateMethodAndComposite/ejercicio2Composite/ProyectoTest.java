package tp5TemplateMethodAndComposite.ejercicio2Composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProyectoTest {
    @Test
    public void testTiempoTotalProyectoSimple() {
        ImpresorPorConsola consola = System.out::println;
        Proyecto tareaCompleja = new Proyecto("Historia: Diseño",consola);

        tareaCompleja.agregar(new Tarea("UI Básica", 4, consola));
        tareaCompleja.agregar(new Spike("Análisis técnico", 2, consola));

        tareaCompleja.print("");
        assertEquals(6, tareaCompleja.tiempo());
    }

    @Test
    public void testProyectoConHistoriaCompleja() {
        ImpresorPorConsola consola = System.out::println;
//        Proyecto proyecto = new Proyecto(consola);

        Proyecto historia = new Proyecto("Historia: Registro", consola);
        historia.agregar(new Tarea("Backend", 3, consola));
        historia.agregar(new Tarea("Frontend", 2, consola));
        historia.agregar(new Spike("Revisión UX", 1, consola));

//        proyecto.agregar(historia);

        historia.print("");
        assertEquals(6, historia.tiempo());
    }

}
