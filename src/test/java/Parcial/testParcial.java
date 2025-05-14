package Parcial;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testParcial {

    @Test
    public void test(){
        var causa1 = new Causa("causa1");
        var causa2 = new Causa("causa2");

        Collection<Causa> coleccionCausas= new ArrayList<>();
        coleccionCausas.add(causa1);
        coleccionCausas.add(causa2);

        Collection<Causa> coleccionCausas2= new ArrayList<>();
        coleccionCausas2.add(causa1);
        coleccionCausas2.add(causa2);
        coleccionCausas2.add(causa2);
        coleccionCausas2.add(causa2);

        var juez1 = new Juez("nombre","apellido",coleccionCausas);
        var juez2 = new Juez("nombre","apellido",coleccionCausas2);

        Collection<Juez> jueces = new ArrayList<>();
        jueces.add(juez1);
        jueces.add(juez2);

        var controller = new Controlador(jueces);

        assertEquals(6,controller.calcularCausasTotales().get().intValue());
    }
}
