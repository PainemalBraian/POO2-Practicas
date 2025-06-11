package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class ComboFamiliar extends PedidoDecorator{

    public ComboFamiliar(Combo combo) {
        super(combo);
        cargarContenidoCombo();
    }

    public void descripcion(){
        System.out.println("\nCombo Familiar");
        super.descripcion();
    }

    private void cargarContenidoCombo(){
        super.addCosto(500);
        super.addContenido("Hamburguesa x3");
        super.addContenido("Papas x3");
        super.addContenido("Refrescos x3");
    }
}
