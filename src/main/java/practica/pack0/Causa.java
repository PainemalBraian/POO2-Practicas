package practica.pack0;

import static java.util.Objects.isNull;

public class Causa {
    private String titulo;

    public Causa(String titulo) { //Throws CausaException
        if (isNull(titulo) || titulo.isEmpty() )
            throw new RuntimeException("El titulo no puede estar vacio");
        this.titulo = titulo;
    }
}
