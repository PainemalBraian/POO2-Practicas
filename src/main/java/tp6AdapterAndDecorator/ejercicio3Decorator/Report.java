package tp6AdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public interface Report {

    void export(File file);

    void simularExport(String fileName);
}
