package tp4.ejercicio3.model.DAO;

import tp4.ejercicio3.model.exceptions.InscripcionException;

import java.util.List;

public interface ConcursoDAOAdaptable {
    List<String> obtenerConcursos() throws InscripcionException;
}
