package tp5TemplateMethodAndComposite.ejercicio2Composite;

public class TestProyecto {
    public static void main(String[] args) {
        ImpresorPorConsola consola = System.out::println;

//        Proyecto proyecto = new Proyecto(consola);

        Tarea tarea1 = new Tarea("Login", 5, consola);
        Spike spike1 = new Spike("Investigación", 3, consola);

        TareaCompleja historia1 = new TareaCompleja("Historia de usuario: Autenticación", consola);
        historia1.agregar(tarea1);
        historia1.agregar(spike1);

//        proyecto.agregar(historia1);
        historia1.print("");
    }
}

