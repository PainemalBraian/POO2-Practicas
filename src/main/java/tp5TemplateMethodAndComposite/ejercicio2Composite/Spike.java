package tp5TemplateMethodAndComposite.ejercicio2Composite;

public class Spike implements ItemDeProyecto {
    private String nombre;
    private int horas;
    private ImpresorPorConsola printer;

    public Spike(String nombre, int horas, ImpresorPorConsola printer) {
        this.nombre = nombre;
        this.horas = horas;
        this.printer = printer;
    }

    @Override
    public void print(String mensaje) {
        this.printer.println(mensaje + "Spike - " + nombre);
    }

    @Override
    public int tiempo() {
        return horas;
    }
}

