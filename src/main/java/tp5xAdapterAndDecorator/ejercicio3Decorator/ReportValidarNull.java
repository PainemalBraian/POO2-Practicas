package tp5xAdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public class ReportValidarNull extends ReportDecorator {

    public ReportValidarNull(Report reporte) {
        super(reporte);
    }

    public void export(File file) {
        if (file == null || file.getPath().equals("")) {
            throw new IllegalArgumentException("PathName del File NULL; no puedo exportar...");
        }
        // Exportar el reporte a un archivo.
        super.export(file);
    }

    public void simularExport(String fileName) {
        if (fileName.equals("null") || fileName.equals("")) {
            throw new IllegalArgumentException("PathName del File NULL; no puedo exportar...");
        }
        // Exportar el reporte a un archivo.
        super.simularExport(fileName);
    }
}
