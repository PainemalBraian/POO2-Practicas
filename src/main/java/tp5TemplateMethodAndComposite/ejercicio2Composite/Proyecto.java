package tp5TemplateMethodAndComposite.ejercicio2Composite;

import java.util.ArrayList;
import java.util.List;
// Tarea Compleja en diagrama
public class Proyecto implements ItemDeProyecto {
    private String nombre;
    private List<ItemDeProyecto> subtareas = new ArrayList();
    private final ImpresorPorConsola printer;

    public Proyecto(String nombre, ImpresorPorConsola printer) {
        this.nombre = nombre;
        this.printer = printer;
    }

    public void agregar(ItemDeProyecto tarea) {
        subtareas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void print(String mensaje) {
        this.printer.println(mensaje + "Proyecto - " + this.nombre);
        for (ItemDeProyecto sub : subtareas)
            sub.print(mensaje + " ");
        printer.println("Tiempo total estimado del proyecto: " + tiempo() + " horas");
    }

    @Override
    public int tiempo() {
        return subtareas.stream().mapToInt(ItemDeProyecto::tiempo).sum();
    }

    public List<ItemDeProyecto> getSubtareas() {
        return this.subtareas;
    }
}
