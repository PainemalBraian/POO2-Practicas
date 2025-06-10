package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

public class LiderProyecto implements Categoria{
    private float salarioBase;
    private List<Categoria> subordinados = new ArrayList<>();

    public LiderProyecto(float salarioBase) {
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
        if (subordinado.getClass() != EmpleadoRegular.class)
            throw new RuntimeException("Un Lider de Proyecto solo puede insertar un subordinado de Empleado Regular");
        subordinados.add(subordinado);
    }

}
