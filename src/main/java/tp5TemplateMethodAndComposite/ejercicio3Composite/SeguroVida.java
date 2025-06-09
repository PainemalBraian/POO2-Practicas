package tp5TemplateMethodAndComposite.ejercicio3Composite;

public class SeguroVida implements Seguro{
    private double costoIndividual;

    public SeguroVida(double costoIndividual) {
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
