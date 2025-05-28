package tp5TemplateMethodAndComposite.ejercicio4TemplateMethod;

import static java.time.LocalDate.now;

public class CalculadorJubilado extends Calculador {
    public static final double COEFICIENTEPRECIO = 0.1;

    public CalculadorJubilado(LogTransaction log, int mes) {
        super(log, mes);
    }

    @Override
    double calcularVariantePrecio() {
        if (!(mesEnPromocion == now().getMonth().getValue())) //Así se encontraba la instrucción en el ejercicio.
            return COEFICIENTEPRECIO;
        return 0;
    }

}
