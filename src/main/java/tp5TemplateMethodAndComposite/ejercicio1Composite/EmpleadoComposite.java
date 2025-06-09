package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoComposite implements Categoria {
    private List<Categoria> subordinados = new ArrayList<>();

    public EmpleadoComposite() {
    }

    @Override
    public float salario() {
        return calcularSalarioTotal();
    }

    @Override
    public void agregarSubordinado(Categoria subordinado) {
        subordinados.add(subordinado);
    }

    public float calcularSalarioTotal() {
        float total = 0;
        for (Categoria subordinado : subordinados) {
            total += subordinado.salario();
        }
        return total;
    }
}

