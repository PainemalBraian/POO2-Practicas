package tp2Desacoplamiento.concurso.persistance;

import tp2Desacoplamiento.concurso.Almacenamiento;
import tp2Desacoplamiento.concurso.EscritorArchivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivoEnDisco implements EscritorArchivo,Almacenamiento {
    private String rutaArchivo;

    public EscritorDeArchivoEnDisco(String rutaArchivo) {
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
