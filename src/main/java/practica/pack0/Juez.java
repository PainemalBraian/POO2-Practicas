package practica.pack0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static java.util.Objects.isNull;

public class Juez {
    private String nombre;
    private String apellido;
    private Collection<Causa> causasACargo = new ArrayList<>();

    public Juez(String nombre, String apellido, Collection<Causa> causasACargo) {//Throws JuezException
        if (isNull(causasACargo) || causasACargo.isEmpty() )
            throw new RuntimeException("La Lista no puede estar vacia");
        if (isNull(nombre) || nombre.isEmpty() )
            throw new RuntimeException("El nombre no puede estar vacio");
        if (isNull(apellido) || apellido.isEmpty() )
            throw new RuntimeException("El apellido no puede estar vacio");

        this.nombre = nombre;
        this.apellido = apellido;
        this.causasACargo = causasACargo;
    }

    public void agregarCausa(Causa causa) {
        if (isNull(causa) )
            throw new RuntimeException("Causa no puede estar vacio");
        this.causasACargo.add(causa);
    }

    public Collection<Causa> causas() {
        return causasACargo;
    }

    public Optional<Integer> cantidadCausasACargo(){
        int cantidad = 0;
        if (causasACargo.isEmpty())
            return Optional.empty();
        cantidad = causasACargo.size();
        return Optional.of(cantidad);
    }
    public String obtenerNombreCompleto(){
        return nombre +" "+ apellido;
    }
}