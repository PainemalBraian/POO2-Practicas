package tp5.ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja implements ItemDeProyecto {
    private String nombre;
    private List<ItemDeProyecto> subtareas = new ArrayList();
    private final ImpresorPorConsola printer;

    public TareaCompleja(String nombre, ImpresorPorConsola printer) {
        this.nombre = nombre;
        this.printer = printer;
    }

    public void agregarSubtarea(ItemDeProyecto tarea) {
        subtareas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void print(String mensaje) {
        this.printer.println(mensaje + "- " + this.nombre);
        for (ItemDeProyecto sub : subtareas)
            sub.print(mensaje + " ");
    }

    public List<ItemDeProyecto> getSubtareas() {
        return this.subtareas;
    }
}
