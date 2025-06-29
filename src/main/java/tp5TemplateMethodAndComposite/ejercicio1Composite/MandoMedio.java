package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

public class MandoMedio implements Categoria{
    private float salarioBase;
    private List<Categoria> subordinados = new ArrayList<>();

    public MandoMedio(float salarioBase) {
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
        if (subordinado.getClass() != LiderProyecto.class)
            throw new RuntimeException("Un Mando Medio solo puede insertar un subordinado de tipo Lider de Proyecto");
        subordinados.add(subordinado);
    }
}
