package tp5xAdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public class ReportValidarCompleto extends ReportValidarNull {

    public ReportValidarCompleto(Report reporte) {
        super(reporte);
    }

    public void export(File file) {
        if (file.exists()) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }
        // Comprobar si es null y luego Exportar el reporte a un archivo.
        super.export(file);
    }

    public void simularExport(String fileName) {
        if (fileName.equals("Existe")) {
            throw new IllegalArgumentException("El archivo ya existe...");
        }
        // Comprobar si es null y luego Exportar el reporte a un archivo.
        super.simularExport(fileName);
    }
}
