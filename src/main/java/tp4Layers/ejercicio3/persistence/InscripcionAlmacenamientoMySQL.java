package tp4Layers.ejercicio3.persistence;

import tp4Layers.ejercicio3.model.DAO.InscripcionDAO;
import tp4Layers.ejercicio3.model.entities.Persona;
import tp4Layers.ejercicio3.model.exceptions.InscripcionException;

import java.sql.*;

public class InscripcionAlmacenamientoMySQL implements InscripcionDAO {
    private Connection conexion;

    public InscripcionAlmacenamientoMySQL(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void guardarInscripcion(Persona persona) throws InscripcionException {
        String sql = """
            INSERT INTO inscripcion (nombre, apellido, dni, telefono, email, id_concurso)
            VALUES (?, ?, ?, ?, ?, (SELECT id FROM concurso WHERE nombre = ?))
            """;

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, persona.getName());
            stmt.setString(2, persona.getLastName());
            stmt.setString(3, persona.getDni());
            stmt.setString(4, persona.getPhone().getPhoneNumber());
            stmt.setString(5, persona.getEmail().getEmailAdress());
            stmt.setString(6, persona.getConcurso().getConcursoName());

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new InscripcionException("Error al guardar inscripción: " + e.getMessage());
        }
    }
}

