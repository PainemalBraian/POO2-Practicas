package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

enum Porcion { Tomate, Papas, Carne, Queso }

// Usado como un "colaborador" del sistema
public class PorcionExtra{
    private int costoAdicional = 50;
    Porcion porcion;

    public PorcionExtra(Porcion porcion) {
        this.porcion = porcion;
    }

    int costo(){
        return this.costoAdicional;
    }
    String porcion(){
        return String.valueOf(this.porcion);
    }

}
