package tp5TemplateMethodAndComposite.ejercicio2Composite;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private List<ItemDeProyecto> tareas = new ArrayList();
    private ImpresorPorConsola printer;

    public Proyecto(ImpresorPorConsola printer) {
        this.printer = printer;
    }

    public void agregar(ItemDeProyecto tarea) {
        tareas.add(tarea);
    }

    public void mostrar() {
        for (ItemDeProyecto tarea : tareas) {
            tarea.print("");
        }
    }

    private void mostrarTarea(ItemDeProyecto tarea, String indent) {
        if (tarea instanceof Tarea) {
            Tarea t = (Tarea) tarea;
            this.printer.println(indent + "- " + t.getNombre());
        } else if (tarea instanceof TareaCompleja) {
            TareaCompleja tc = (TareaCompleja) tarea;
            this.printer.println(indent + "+ " + tc.getNombre());
            for (ItemDeProyecto sub : tc.getSubtareas()) {
                mostrarTarea(sub, indent + "  ");
            }
        }
    }
}