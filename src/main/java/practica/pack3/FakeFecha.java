package practica.pack3;

import java.time.LocalDate;

public class FakeFecha implements ProveedorFecha{
    private LocalDate fecha;

    public FakeFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    @Override
    public LocalDate fecha(){
        return fecha;
    }
}
