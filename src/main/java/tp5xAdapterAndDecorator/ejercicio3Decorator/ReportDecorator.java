package tp5xAdapterAndDecorator.ejercicio3Decorator;

import java.io.File;

public abstract class ReportDecorator implements Report{
    protected Report report;

    public ReportDecorator(Report report) {
        this.report = report;
    }

    @Override
    public void export(File file) {
        report.export(file);
    }

    @Override
    public void simularExport(String fileName) {
        report.simularExport(fileName); // delegación por defecto
    }
}
