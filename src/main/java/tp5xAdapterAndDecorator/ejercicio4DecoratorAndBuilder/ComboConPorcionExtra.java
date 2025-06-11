package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class ComboConPorcionExtra extends PedidoDecorator {

    public static final int COSTO_EXTRA = 50;

    public ComboConPorcionExtra(Combo combo, Porcion porcion) {
        super(combo);
        cargarPorcionExtra(porcion);
    }

    private void cargarPorcionExtra(Porcion porcion) {
        super.addContenido( "Extra: " + porcion.toString());
        super.addCosto(COSTO_EXTRA);
    }

}

