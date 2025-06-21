package tp5TemplateMethodAndComposite.ejercicio4TemplateMethod;

public class ConsolaLog implements LogTransaction {
    @Override
    public void log(String nombreClase) {
        System.out.println("Transacción registrada desde: " + nombreClase);
    }
}

