package tp8Proxy.ejercicio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ejemplo {

    public enum Permiso {
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
    }
    public class FileAccess {
        private String ruta;
        private String nombreArchivo;

        public FileAccess(String ruta, String nombre) {
            this.ruta = ruta;
            this.nombreArchivo = nombre;
        }
        public String readFile() throws IOException {
            return Files.readString(Paths.get(this.ruta + "/" + this.nombreArchivo));
        }
    }
}
