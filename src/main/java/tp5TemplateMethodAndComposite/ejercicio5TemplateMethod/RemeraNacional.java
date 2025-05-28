package tp5TemplateMethodAndComposite.ejercicio5TemplateMethod;

public class RemeraNacional extends Remera{
    static final double RECARGO_TRANSPORTE = 0.015; // Las remeras nacionales tienen un recargo de 1,5 % del costo de transporte y una bonificación del 20%.
    static final double BONIFICACION = 0.20; //Bonificación se entiende por descuento para el cliente

    public RemeraNacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    double calcularVariante() {
        return (1 + RECARGO_TRANSPORTE - BONIFICACION); // 0.815
    }
}
