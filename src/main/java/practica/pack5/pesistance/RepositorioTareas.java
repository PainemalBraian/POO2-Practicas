package practica.pack5.pesistance;

import practica.pack5.backend.interfaces.Repositorio;
import practica.pack5.backend.model.Tarea;

import java.util.ArrayList;
import java.util.List;

// Persistencia
public class RepositorioTareas implements Repositorio {
    // Se podria implementar DAO interfaces y DAOS de implementación para encapsular model, pero no es requerido
    private List<Tarea> tareas = new ArrayList<>();

    @Override
    public void guardar(Tarea tarea) {
        tareas.add(tarea);
    }

    @Override
    public List<Tarea> obtenerTodas() {
        return tareas;
    }
}