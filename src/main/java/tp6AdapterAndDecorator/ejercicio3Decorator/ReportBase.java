package tp6AdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public class ReportBase implements Report {
    private String reporte;

    public ReportBase(String reporte) {
        this.reporte = reporte;
    }

    @Override
    public void export(File file) {
        // Exportar el reporte a un archivo.
    }

    @Override
    public void simularExport(String fileName) {
        // Exportar el reporte a un archivo.
        System.out.println("File: "+fileName +"\nContenido: "+ reporte);
    }
}
