package tp5xAdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public class ReportValidarNull extends ReportDecorator {

    public ReportValidarNull(Report reporte) {
        super(reporte);
    }

    public void export(File file) {
        if (file == null) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        // Se elimino validacion "Si existe"
        // Exportar el reporte a un archivo.
        super.export(file);
    }

    public void simularExport(String fileName) {
        if (fileName.equals("null")) {
            throw new IllegalArgumentException("File es NULL; no puedo exportar...");
        }
        // Se elimino validacion "Si existe"
        // Exportar el reporte a un archivo.
        super.simularExport(fileName);
    }
}
