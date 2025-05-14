package tp4.ejercicio3.persistence;

import tp4.ejercicio3.model.DAO.ConcursoDAOAdaptable;
import tp4.ejercicio3.model.exceptions.InscripcionException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ConcursoDAO implements ConcursoDAOAdaptable {
    private static final String ARCHIVO_CONCURSOS = "e:/Users/Usuario/Desktop/concursos.txt";
//    private static final String ARCHIVO_CONCURSOS = System.getProperty("user.home") + "/Desktop/concursos.txt";

    @Override
    public List<String> obtenerConcursos() throws InscripcionException {
        List<String> concursos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_CONCURSOS))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    concursos.add(linea.trim());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            throw new InscripcionException("Error al cargar los concursos");
        }

        return concursos;
    }
}

