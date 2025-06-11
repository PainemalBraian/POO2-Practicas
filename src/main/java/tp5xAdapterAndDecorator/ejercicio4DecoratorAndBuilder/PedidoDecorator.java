package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public abstract class PedidoDecorator implements Combo {
    Combo combo;

    public PedidoDecorator(Combo combo) {
        this.combo = combo;
    }

    public void precio(){
        combo.precio();
    }

    public void descripcion(){
        combo.descripcion();
    }

    @Override
    public void addCosto(int costo) {
        combo.addCosto(costo);
    }

    public void addContenido(String elemento){
        combo.addContenido(elemento);
    }

    public void addPorcionExtra(PorcionExtra p){
        addContenido("Extra: "+p.porcion());
        addCosto(p.costo());
    }

}
