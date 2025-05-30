package practica.pack3;

import java.time.LocalDate;

public class FechaReal implements ProveedorFecha{
    @Override
    public LocalDate fecha() {
        return LocalDate.now();
    }
}
