package tp5TemplateMethodAndComposite.ejercicio1Composite;

public class EmpleadoRegular implements Categoria {
    private float salarioBase;

    public EmpleadoRegular(float salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public float salario() {
        return salarioBase;
    }

    @Override
    public void agregarSubordinado(Categoria subordinado) {
        throw new RuntimeException("Un empleado regular no puede tener subordinados.");
    }

}