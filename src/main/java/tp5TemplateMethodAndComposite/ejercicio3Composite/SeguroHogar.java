package tp5TemplateMethodAndComposite.ejercicio3Composite;

public class SeguroHogar implements Seguro{
    private double costoIndividual;

    public SeguroHogar(double costoIndividual) {
        this.costoIndividual = costoIndividual;
    }

    @Override
    public double costo() {
        return costoIndividual;
    }

    @Override
    public void agregarSeguro(Seguro seguro) {
        throw  new RuntimeException("Este tipo de seguro no puede agregar seguros");
    }

}
