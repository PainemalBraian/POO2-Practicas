package practica.pack5.backend.services;

import practica.pack5.backend.interfaces.Repositorio;
import practica.pack5.backend.model.Tarea;

import java.util.List;

// Backend / Servicio
public class ServicioTareas {
    private Repositorio repo;

    public ServicioTareas(Repositorio repo) {
        this.repo = repo;
    }

    public void crearTarea(String descripcion) {
        repo.guardar(new Tarea(descripcion));
    }

    public List<Tarea> listarTareas() {
        return repo.obtenerTodas();
    }

    public void completarTarea(int index) {
        List<Tarea> tareas = repo.obtenerTodas();
        if (index >= 0 && index < tareas.size()) {
            tareas.get(index).marcarComoCompletada();
        }
    }
}
