package tp5TemplateMethodAndComposite.ejercicio5TemplateMethod;

public class Main {
    public static void main(String[] args) {
        Remera remera = new RemeraImportada(1000);
        Remera remera2 = new RemeraNacional(1000);

        remera.calcularPrecio();
        remera2.calcularPrecio();
    }
}
