package tp5TemplateMethodAndComposite.ejercicio3Composite;

import java.util.ArrayList;
import java.util.List;

public class SegurosComposite implements Seguro {
    public static final double DESCUENTO_POR_SEGURO = 0.05;
    private List<Seguro> seguros = new ArrayList<>();

    public SegurosComposite() {}

    @Override
    public double costo() {
        double total = 0;
        for (Seguro s : seguros) {
            total += s.costo();
        }
        // El costo de cada paquete está dado por el costo individual de cada seguro
        // Pero aplica un descuento del 5%, (acumulativo), por cada seguro incluido en el paquete.

        double descuento = DESCUENTO_POR_SEGURO * seguros.size();
        double descuentoAcumulado = 1 - descuento;

        // Se asegura que el descuento no sea mayor a 100%
        if (descuentoAcumulado < 0) {
            descuentoAcumulado = 0;
        }

        return total * descuentoAcumulado;
    }

    public void agregarSeguro(Seguro seguro) {
        seguros.add(seguro);
    }

//    public void agregarPaquete(List<Seguro> seguros) {
//        this.seguros.addAll(seguros);
//    }

}
