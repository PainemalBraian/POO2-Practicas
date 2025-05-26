package tp4Layers.ejercicio3.model.DAO;

import tp4Layers.ejercicio3.model.entities.Persona;
import tp4Layers.ejercicio3.model.exceptions.InscripcionException;

public interface InscripcionDAO {
    void guardarInscripcion(Persona persona) throws InscripcionException;
}
