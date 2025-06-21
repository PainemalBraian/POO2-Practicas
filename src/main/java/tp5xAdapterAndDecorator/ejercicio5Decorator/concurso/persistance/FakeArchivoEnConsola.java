package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.ConcursoDecorator;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Almacenamiento;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;

public class FakeArchivoEnConsola extends ConcursoDecorator implements Almacenamiento {
    public FakeArchivoEnConsola(Concurso concurso) {
        super(concurso);
        concurso.addAlmacenamiento(this);
    }

    @Override
    public void guardarInscripcion(String contenido) {
        System.out.println("Fake Archivo (Consola)" + "\nContenido: " + contenido);
    }
}
