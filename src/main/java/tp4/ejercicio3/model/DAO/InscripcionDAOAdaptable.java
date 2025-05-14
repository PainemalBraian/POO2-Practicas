package tp4.ejercicio3.model.DAO;

import tp4.ejercicio3.model.entities.Persona;
import tp4.ejercicio3.model.exceptions.InscripcionException;

public interface InscripcionDAOAdaptable {
    void guardarInscripcion(Persona persona) throws InscripcionException;
}
