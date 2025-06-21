package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.ConcursoDecorator;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Almacenamiento;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.ResourceBundle;

public class AlmacenamientoBaseDatosConcurso extends ConcursoDecorator implements Almacenamiento {
    protected Connection conn = null;
    protected static Properties prop = null;


    public AlmacenamientoBaseDatosConcurso(Concurso concurso) {
        super(concurso);
        concurso.addAlmacenamiento(this);
    }

    @Override
    public void guardarInscripcion(String contenido) {
        try (Connection conn = connect()) {
            // Dividir el contenido en base al formato proporcionado
            String[] datos = contenido.split("\n");
            String fechaInscripcion = datos[0].split(":")[1].trim();                // "Fecha de Inscripción: dd/MM/yyyy"
            //int idInscripcion = Integer.parseInt(datos[1].split(":")[1].trim());    // "ID Inscripción: ID"
            int idConcurso = Integer.parseInt(datos[1].split(":")[1].trim());       // "ID Concurso: ID"
            String fechaLimite = datos[2].split(":")[1].trim();                     // "Fecha Límite: dd/MM/yyyy"
            String fechaApertura = datos[3].split(":")[1].trim();                   // "Fecha Apertura: dd/MM/yyyy"

            // Query para insertar los datos
            String sql = "INSERT INTO inscripciones (fecha_inscripcion, id_concurso, fecha_limite, fecha_apertura) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDate(1, java.sql.Date.valueOf(LocalDate.parse(fechaInscripcion, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                stmt.setInt(2, idConcurso);
                stmt.setDate(3, java.sql.Date.valueOf(LocalDate.parse(fechaLimite, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
                stmt.setDate(4, java.sql.Date.valueOf(LocalDate.parse(fechaApertura, DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la inscripción en la base de datos: " + e.getMessage());
        }
    }

    private static Properties getProperties() throws RuntimeException {
        Properties prop = new Properties();
        try {
            ResourceBundle infoDataBase = ResourceBundle.getBundle("database");
            prop.setProperty("connection", infoDataBase.getString("db.url"));
            prop.setProperty("username", infoDataBase.getString("db.user"));
            prop.setProperty("password", infoDataBase.getString("db.password"));
        } catch (Exception e1) {
            throw new RuntimeException("Ocurrio un error al leer la configuracion desde el archivo "+ e1.getMessage());
        }
        return prop;
    }

    protected Connection connect() throws SQLException {
        try {
            prop = getProperties();
            conn = DriverManager.getConnection(prop.getProperty("connection"), prop.getProperty("username"),
                    prop.getProperty("password"));
            if (conn == null) {throw new SQLException("Error al conectar con la base de datos");}
            conn.setAutoCommit(true);
            return conn;
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con base de datos: "+ e.getMessage());
        }
    }

    public void disconnect() throws SQLException{
        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
                throw new SQLException("Error al cerrar la sesion");
            }
        }
    }

}
