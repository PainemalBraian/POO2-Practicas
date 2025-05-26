package tp4Layers.ejercicio1.model;

import tp4Layers.ejercicio1.database.DBControlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteDAO {
    private Connection connection;

    public ParticipanteDAO() throws Exception {
        try {
            this.connection = DBControlador.conectar();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public void updateParticipante(Participante p)throws Exception{
        String sql = "INSERT INTO participantes VALUES (?, ?, ?)";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, p.getNombre());
            st.setString(2, p.getTelefono());
            st.setString(3, p.getRegion());
            st.executeUpdate();
        }catch (SQLException e){ throw new Exception("Error al actualizar");}

    }
}
