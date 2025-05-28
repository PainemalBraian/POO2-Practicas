package tp5TemplateMethodAndComposite.ejercicio1Composite;

// No incluye Subordinados
public class EmpleadoRegular implements Categoria {
    private String nombreCategoria;
    private float salarioBase;

    public EmpleadoRegular(String nombreCategoria, float salarioBase) {
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
        throw new RuntimeException("Un empleado regular no puede tener subordinados.");
    }

    @Override
    public float calcularSalarioTotal() {
        return salarioBase;
    }
}