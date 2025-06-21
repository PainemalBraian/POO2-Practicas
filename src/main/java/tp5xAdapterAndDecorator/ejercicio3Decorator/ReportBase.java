package tp5xAdapterAndDecorator.ejercicio3Decorator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReportBase implements Report {
    private String reporte;

    public ReportBase(String reporte) {
        this.reporte = reporte;
    }

    @Override
    public void export(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(reporte);
            System.out.println("Archivo exportado correctamente en: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("Error al exportar el archivo: " + e.getMessage());
        }
    }

    @Override
    public void simularExport(String fileName) {
        // Exportar el reporte a un archivo.
        System.out.println("File: "+fileName +"\nContenido: "+ reporte);
    }
}
