package tp5TemplateMethodAndComposite.ejercicio4TemplateMethod;

public class Main {
    public static void main(String[] args) {
        LogTransaction consola = new ConsolaLog();
        Calculador cal = new CalculadorNoJubilado(consola,5);
        Calculador cal2 = new CalculadorJubilado(consola,4);

        cal.calcularPrecio(1000);
        cal2.calcularPrecio(2000);
    }
}
