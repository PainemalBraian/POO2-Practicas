package tp5TemplateMethodAndComposite.ejercicio2Composite;

public class Tarea implements ItemDeProyecto{
    private final String nombre;
    private final ImpresorPorConsola printer;

    public Tarea(String nombre, ImpresorPorConsola printer) {
        this.nombre = nombre;
        this.printer = printer;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void print(String mensaje) {
        this.printer.println(mensaje + "- " + this.getNombre());
    }
}
