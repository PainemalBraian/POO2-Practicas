package tp5TemplateMethodAndComposite.ejercicio5TemplateMethod;

public class RemeraImportada extends Remera{
    static final double RECARGO = 0.03; // Las remeras importadas sobre el precio unitario tienen un 3% de recargo más un 5% de impuesto aduanero.
    static final double IMPUESTO_ADUANERO = 0.05;

    public RemeraImportada(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    double calcularVariante() {
        return (1 + RECARGO + IMPUESTO_ADUANERO); //1.08
    }
}
