package practica.pack5.backend.interfaces;

import practica.pack5.backend.model.Tarea;

import java.util.List;

public interface Repositorio {
    void guardar(Tarea tarea);

    List<Tarea> obtenerTodas();
}
