package tp8Proxy.ejercicio1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class ejemplo {
    public class Main {
        public void main(String args[]) {
            PersonaDao dao = new PersonaDao();
            Persona p = dao.personaPorId(1);
            System.out.println(p.nombre());
            for (Telefono telefono : p.telefonos()) {
                System.out.println(telefono);
            }
        }
    }

    public class Telefono {
        private String numero;

        public Telefono(String numero) {
            this.numero = numero;
        }
        public String numero() {
            return numero;
        }
        @Override
        public String toString() {
            return numero;
        }
    }

    public class Persona {
        private int id;
        private String nombre;
        private Set<Telefono> telefonos;

        public Persona(int id, String nombre, Set<Telefono> telefonos) {
            this.id = id;
            this.nombre = nombre;
            this.telefonos = telefonos;
        }
        public Telefono[] telefonos() {
            return telefonos.toArray(new Telefono[telefonos.size()]);
        }
        public String nombre() {
            return nombre;
        }
    }

    public class PersonaDao {
        private Connection obtenerConexion() {
            //Utilice aquí su motor de BD preferido
            return null;
        }

        public Persona personaPorId(int id) {
            String sql = "select p.nombre,t.numero " + "from personas p, telefonos t " + "where p.id = t.idpersona and p.id = ?";
            try (Connection conn = obtenerConexion();
                 PreparedStatement statement =
                         conn.prepareStatement(sql);) {
                statement.setInt(1, id);
                ResultSet result = statement.executeQuery();
                Set<Telefono> telefonos = new HashSet<Telefono>();
                String nombrePersona = null;
                while (result.next()) {
                    nombrePersona = result.getString(1);
                    telefonos.add(new Telefono(result.getString(2)));
                }
                return new Persona(id, nombrePersona, telefonos);
            } catch(SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
