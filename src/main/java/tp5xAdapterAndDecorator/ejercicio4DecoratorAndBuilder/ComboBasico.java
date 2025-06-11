package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class ComboBasico extends PedidoDecorator{

    public ComboBasico(Combo combo) {
        super(combo);
        cargarContenidoCombo();
    }

    public void descripcion(){
        System.out.println("\nCombo Básico");
        super.descripcion();
    }

    private void cargarContenidoCombo(){
        super.addCosto(200);
        super.addContenido("Hamburguesa");
        super.addContenido("Papas");
        super.addContenido("Refrescos");
    }
}
