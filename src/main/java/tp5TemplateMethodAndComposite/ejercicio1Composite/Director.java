package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

public class Director implements Categoria{
    private float salarioBase;
    private List<Categoria> subordinados = new ArrayList<>();

    public Director( float salarioBase) {
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
        if (subordinado.getClass() != Gerente.class)
            throw new RuntimeException("Un Director solo puede insertar un subordinado de tipo Gerente");
        subordinados.add(subordinado);
    }
}
