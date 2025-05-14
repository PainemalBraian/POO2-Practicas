package tp4.ejercicio3.persistence;

import tp4.ejercicio3.model.DAO.InscripcionDAOAdaptable;
import tp4.ejercicio3.model.entities.Persona;
import tp4.ejercicio3.model.exceptions.InscripcionException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class InscripcionDAO implements InscripcionDAOAdaptable {
    private static final String ARCHIVO_INSCRIPTOS = "e:/Users/Usuario/Desktop/inscriptos.txt";

//    private static final String ARCHIVO_INSCRIPTOS = System.getProperty("user.home") + "/Desktop/inscriptos.txt";
    @Override
    public void guardarInscripcion(Persona p) throws InscripcionException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_INSCRIPTOS, true))) {
            writer.write(p.getName() + "," + p.getLastName() + "," + p.getDni() + "," + p.getPhone().getPhoneNumber() + "," + p.getEmail().getEmail() + "," + p.getConcurso().getConcurso());
            writer.newLine();
        } catch (IOException e) {
//            e.printStackTrace();
            throw new InscripcionException("Error al inscribir: "+ e.getMessage() );
        }
    }
}
