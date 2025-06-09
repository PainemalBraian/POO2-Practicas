package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

public class Gerente implements Categoria{
    private float salarioBase;
    private List<Categoria> subordinados = new ArrayList<>();

    public Gerente(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public float salario() {
        float total = salarioBase;
        for (Categoria subordinado : subordinados) {
            total += subordinado.salario();
        }
        return total;
    }

    @Override
    public void agregarSubordinado(Categoria subordinado) {
        subordinados.add(subordinado);
    }

}
