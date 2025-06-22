package tp8Proxy.ejercicio1;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PersonaDAO {
    private Connection obtenerConexion() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopProxy?useSSL=false","yo", "contrasena");
            if (conn == null) {
                throw new RuntimeException("Error al conectar con la base de datos");
            }
            conn.setAutoCommit(true);
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar con base de datos: "+ e.getMessage());
        }
    }

    public Persona personaPorId(int id) {
        String sql = "SELECT nombre FROM personas WHERE id = ?";
        try (Connection conn = obtenerConexion();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                String nombrePersona = result.getString("nombre");
                //Uso de proxy
                Set<Telefono> telefonosProxy = new SetProxyTelefonos(id);
                return new Persona(id, nombrePersona, telefonosProxy);
            } else {
                throw new RuntimeException("No se encontró persona con ID " + id);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}