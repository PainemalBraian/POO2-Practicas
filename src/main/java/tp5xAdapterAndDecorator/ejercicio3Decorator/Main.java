package tp5xAdapterAndDecorator.ejercicio3Decorator;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Crear el reporte base con contenido
        Report reporteBase = new ReportBase("Contenido de prueba del reporte.");

        // Envolverlo con validaciones
        Report reporteValidado = new ReportValidarCompleto(reporteBase);
        // También podés probar solo una validación:
        // Report reporteValidado = new ReportValidarNull(new ReportBase("..."));

        // Crear el archivo al que se exportará
        File archivoDestino = new File("reporte_exportado.txt");

        // Ejecutar la exportación
        try {
            reporteValidado.export(archivoDestino);
        } catch (IllegalArgumentException e) {
            System.err.println("Error al exportar: " + e.getMessage());
        }


        // Se valida de manera completa el archivo segun el nombre
//        var reporte = new ReportValidarCompleto(new ReportBase("Rerpotado"));
////        reporte.simularExport("null");
////        reporte.simularExport("Existe");
//        reporte.simularExport("ArchivoNuevo");



        // Se valida unicamente si es "null" el archivo con dicho nombre
//        var report = new ReportValidarNull(new ReportBase("Rerpotado"));
////        report.simularExport("null");
//        report.simularExport("Existe");
//        report.simularExport("ArchivoNuevo");



        // Se valida unicamente si "Existe" el archivo con dicho nombre

//        var repor = new ReportValidarExiste(new ReportBase("Rerpotado"));
//        repor.simularExport("null");
////        repor.simularExport("Existe");
//        repor.simularExport("ArchivoNuevo");


        // Se valida de manera completa el archivo segun el nombre pero armando las dependencias

        var repo = new ReportValidarExiste(
                new ReportValidarNull(
                        new ReportBase("Reportado")));

//        repo.simularExport("null");
//        repo.simularExport("Existe");
        repo.simularExport("ArchivoNuevo");

    }
}
