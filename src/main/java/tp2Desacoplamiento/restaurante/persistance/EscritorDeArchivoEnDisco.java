package tp2Desacoplamiento.restaurante.persistance;

import tp2Desacoplamiento.restaurante.EscritorArchivo;
import tp2Desacoplamiento.restaurante.Almacenamiento;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivoEnDisco implements EscritorArchivo,Almacenamiento { // implement de escritura en disco y db
    private String rutaArchivo;

    public EscritorDeArchivoEnDisco(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public void guardarDetalle(String contenido) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
            writer.write(contenido);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException("Error al guardar: " + e.getMessage());
        }
    }
}
