package tp5TemplateMethodAndComposite.ejercicio1Composite;

import java.util.ArrayList;
import java.util.List;

// Empleados con Subordinados
public class EmpleadoComposite implements Categoria {
    private String nombreCategoria;
    private float salarioBase;
    private List<Categoria> subordinados = new ArrayList<>();

    public EmpleadoComposite(String nombreCategoria, float salarioBase) {
        this.nombreCategoria = nombreCategoria;
        this.salarioBase = salarioBase;
    }

    @Override
    public String tipoCategoria() {
        return nombreCategoria;
    }

    @Override
    public float salario() {
        return salarioBase;
    }

    @Override
    public void agregarSubordinado(Categoria subordinado) {
        subordinados.add(subordinado);
    }

    @Override
    public float calcularSalarioTotal() {
        float total = salarioBase;
        for (Categoria subordinado : subordinados) {
            total += subordinado.calcularSalarioTotal();
        }
        return total;
    }
}

