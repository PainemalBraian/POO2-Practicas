package tp8Proxy.ejercicio1;

import java.sql.*;
import java.util.*;

public class SetProxyTelefonos implements Set<Telefono> {
    private Set<Telefono> reales;
    private boolean cargado = false;
    private int idPersona;

    public SetProxyTelefonos(int idPersona) {
        this.idPersona = idPersona;
    }

    private void cargarTelefonos() {
        if (!cargado) {
            reales = new HashSet<>();
            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopProxy?useSSL=false","yo", "contrasena");
                 PreparedStatement stmt = conn.prepareStatement("SELECT numero FROM telefonos WHERE idPersona = ?")) {
                stmt.setInt(1, idPersona);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    reales.add(new Telefono(rs.getString("numero")));
                }
                cargado = true;
            } catch (SQLException e) {
                throw new RuntimeException("Error al cargar teléfonos desde la base de datos", e);
            }
        }
    }

    // Métodos del Set delegados
    @Override
    public int size() {
        cargarTelefonos();
        return reales.size();
    }

    @Override
    public boolean isEmpty() {
        cargarTelefonos();
        return reales.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        cargarTelefonos();
        return reales.contains(o);
    }

    @Override
    public Iterator<Telefono> iterator() {
        cargarTelefonos();
        return reales.iterator();
    }

    @Override
    public Object[] toArray() {
        cargarTelefonos();
        return reales.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        cargarTelefonos();
        return reales.toArray(a);
    }

    @Override
    public boolean add(Telefono telefono) {
        cargarTelefonos();
        return reales.add(telefono);
    }

    @Override
    public boolean remove(Object o) {
        cargarTelefonos();
        return reales.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        cargarTelefonos();
        return reales.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Telefono> c) {
        cargarTelefonos();
        return reales.addAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        cargarTelefonos();
        return reales.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        cargarTelefonos();
        return reales.removeAll(c);
    }

    @Override
    public void clear() {
        cargarTelefonos();
        reales.clear();
    }
}

