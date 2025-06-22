package tp8Proxy.ejercicio2;

import java.util.List;

enum Permiso {
    ADMIN, BASICO, INTERMEDIO
}

public class Usuario {
    private String name;
    private List<Permiso> permisos;

    public Usuario(String name, List<Permiso> permisos) {
        this.name = name;
        this.permisos = permisos;
    }

    public boolean poseePermiso(Permiso permiso) {
        return permisos.stream().anyMatch(p -> p.equals(permiso));
    }

    public String getNombre() {
        return name;
    }
}
