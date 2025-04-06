package tp2.concurso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorArchivoDocumento implements EscritorArchivo {
    private String rutaArchivo;

    public EscritorArchivoDocumento(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardarInscripcion(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar: " + e.getMessage());
        }
    }
}
