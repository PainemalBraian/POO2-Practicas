package tp4.ejercicio3.model;

import tp4.ejercicio3.model.exceptions.ConcursoException;
import tp4.ejercicio3.model.exceptions.InscripcionException;

import java.util.List;

public interface APITHREE {

    List<String> getTodosLosConcursos()throws ConcursoException; // carga del archivo de texto concursos.txt los concursos

    void saveInscription(String name, String lastName, String dni, String telefono, String email, String concurso) throws InscripcionException;// Guarda en inscriptos.txt los datos de la persona y el concurso elegido

}
