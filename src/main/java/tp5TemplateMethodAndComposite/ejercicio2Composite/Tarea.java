package tp5TemplateMethodAndComposite.ejercicio2Composite;

public class Tarea implements ItemDeProyecto{
    private final String nombre;
    private final int duracion;
    private final ImpresorPorConsola printer;

    public Tarea(String nombre, int duracion, ImpresorPorConsola printer) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.printer = printer;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void print(String mensaje) {
        this.printer.println(mensaje + "Tarea - " + this.getNombre());
    }

    @Override
    public int tiempo() {
        return duracion;
    }
}
