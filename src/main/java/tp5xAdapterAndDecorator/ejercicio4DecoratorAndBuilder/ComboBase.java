package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

import java.util.ArrayList;
import java.util.List;

public class ComboBase implements Combo {
    private int precio=0;
    private List<String> contenido = new ArrayList<>();

    public ComboBase() {
    }

    public void precio(){
        System.out.println("Precio: $" + precio);
    }

    public void addContenido(String elemento){
        this.contenido.add(elemento);
    }

    public void descripcion(){
        for (String elemento : contenido) {
            System.out.println("{ "+elemento+" } ");
        }
    }

    @Override
    public void addCosto(int costo) {
        this.precio += costo;
    }
}
