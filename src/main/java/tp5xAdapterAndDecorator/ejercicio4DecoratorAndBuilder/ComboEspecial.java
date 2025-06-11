package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class ComboEspecial extends PedidoDecorator{
//    List<String> contenidoBasico = Arrays.asList("Hamburguesa", "Papas", "Refresco","Tortilla", "Helado");

    public ComboEspecial(Combo combo) {
        super(combo);
        cargarContenidoCombo(combo);
    }

    public void descripcion(){
        System.out.println("\nCombo Especial");
        super.descripcion();
    }

    private void cargarContenidoCombo(Combo combo){
        combo.addCosto(1000);
        combo.addContenido("Hamburguesa");
        combo.addContenido("Papas");
        combo.addContenido("Refrescos");
        combo.addContenido("Tortilla");
        combo.addContenido("Helado");
    }
}
