package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.ConcursoDecorator;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Almacenamiento;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EscritorDeArchivoEnDisco extends ConcursoDecorator implements Almacenamiento {
    private String rutaArchivo;

    public EscritorDeArchivoEnDisco(String rutaArchivo, Concurso concurso) {
        super(concurso);
        this.rutaArchivo = rutaArchivo;
        concurso.addAlmacenamiento(this);
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
