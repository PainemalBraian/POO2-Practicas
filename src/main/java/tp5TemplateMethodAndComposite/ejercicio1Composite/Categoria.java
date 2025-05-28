package tp5TemplateMethodAndComposite.ejercicio1Composite;

public interface Categoria {

    String tipoCategoria();

    float salario();

    void agregarSubordinado(Categoria subordinado);

    float calcularSalarioTotal();

}