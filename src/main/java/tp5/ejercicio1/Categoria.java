package tp5.ejercicio1;

public interface Categoria {

    String tipoCategoria();

    float salario();

    void agregarSubordinado(Categoria subordinado);

    float calcularSalarioTotal();

}