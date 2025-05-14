package Parcial;

import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.isNull;

public class Controlador {
    private Collection<Juez> jueces;

    public Controlador(Collection<Juez> jueces) {//ControllerException
        if (isNull(jueces) || jueces.isEmpty() )
            throw new RuntimeException("La lista de jueces no puede estar vacia");
        this.jueces = jueces;
    }

    public Optional<Integer> calcularCausasTotales() {
        int cantidadCausas = 0;
        for (Juez juez : jueces) {
            cantidadCausas += juez.cantidadCausasACargo().orElse(0);
        }
//        if (cantidadCausas == 0)
//            return Optional.empty();
//        return Optional.of(cantidadCausas.get());
        return cantidadCausas == 0 ? Optional.empty() : Optional.of(cantidadCausas); //valida si es == 0, si lo es retorna empty, en otro caso el "optional" de ese valor
    }
}