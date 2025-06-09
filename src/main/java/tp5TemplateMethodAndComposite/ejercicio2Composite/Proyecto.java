package tp5TemplateMethodAndComposite.ejercicio2Composite;

import java.util.ArrayList;
import java.util.List;
// No se usa (Eliminar)
public class Proyecto implements ItemDeProyecto{
    private List<ItemDeProyecto> tareas = new ArrayList();
    private ImpresorPorConsola printer;

    public Proyecto(ImpresorPorConsola printer) {
        this.printer = printer;
    }

    public void agregar(ItemDeProyecto tarea) {
        tareas.add(tarea);
    }
    @Override
    public void print(String mensaje) {
        for (ItemDeProyecto tarea : tareas) {
            tarea.print("");
        }
        printer.println("Tiempo total estimado del proyecto: " + tiempo() + " horas");
    }

    @Override
    public int tiempo() {
        return tareas.stream().mapToInt(ItemDeProyecto::tiempo).sum();
    }
}