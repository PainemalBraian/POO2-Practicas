package tp4.ejercicio3.model;

import tp4.ejercicio3.model.DAO.ConcursoDAOAdaptable;
import tp4.ejercicio3.model.DAO.InscripcionDAOAdaptable;
import tp4.ejercicio3.model.entities.Concurso;
import tp4.ejercicio3.model.entities.Email;
import tp4.ejercicio3.model.entities.Persona;
import tp4.ejercicio3.model.entities.ThirdPhone;
import tp4.ejercicio3.model.exceptions.*;
import tp4.ejercicio3.persistence.ConcursoDAO;
import tp4.ejercicio3.persistence.InscripcionDAO;

import java.util.List;

public class ThirdController implements APITHREE{
    ConcursoDAOAdaptable concursoDAO = new ConcursoDAO();
    InscripcionDAOAdaptable inscripcionDAO = new InscripcionDAO();



    @Override
    public List<String>  getTodosLosConcursos()throws ConcursoException {
        List<String> concursos = null; // Si no se da la obtención, nunca retornará el null
        try {
            concursos = concursoDAO.obtenerConcursos();
        } catch (Exception e) {
            throw new ConcursoException(e.getMessage());
        }
        return concursos;
    }

    @Override
    public void saveInscription(String name, String lastName, String dni, String telefono, String email, String concurso) throws InscripcionException {
        try {
            var persona = new Persona(name,lastName,dni,new Email(email), new ThirdPhone(telefono),new Concurso(concurso));
            inscripcionDAO.guardarInscripcion(persona);
        } catch (Exception e) {
            throw new InscripcionException(e.getMessage());
        }
    }
}
