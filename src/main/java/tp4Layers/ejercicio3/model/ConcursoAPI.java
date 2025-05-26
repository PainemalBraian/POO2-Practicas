package tp4Layers.ejercicio3.model;

import tp4Layers.ejercicio3.model.exceptions.ConcursoException;
import tp4Layers.ejercicio3.model.exceptions.InscripcionException;

import java.util.List;

public interface ConcursoAPI {

    List<String> getTodosLosConcursos()throws ConcursoException; // Carga desde el archivo de texto "concursos.txt" los concursos que esten allí

    void saveInscription(String name, String lastName, String dni, String telefono, String email, String concurso) throws InscripcionException;// Guarda en inscriptos.txt los datos de la persona y el concurso elegido

}
