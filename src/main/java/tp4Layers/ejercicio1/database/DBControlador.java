package tp4Layers.ejercicio1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBControlador {
    private static final String URL = "jdbc:derby://localhost:1527/participantes";
    private static final String USER = "app";
    private static final String PASSWORD = "app";

    public static Connection conectar() throws Exception {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new Exception("Error al conectar con DB");
        }
    }

}
