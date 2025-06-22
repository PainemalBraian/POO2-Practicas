package tp8Proxy.ejercicio2;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileAccess implements IFileAccess {
    private String ruta;
    private String nombreArchivo;

    public FileAccess(String ruta, String nombreArchivo) {
        this.ruta = ruta;
        this.nombreArchivo = nombreArchivo;
    }

    @Override
    public String readFile() {
        try {
            var path = Paths.get(ClassLoader.getSystemResource("archivos/" + this.nombreArchivo).toURI());
            return Files.readString(path);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo archivo: " + nombreArchivo + " → " + e.getMessage());
        }
    }


}

