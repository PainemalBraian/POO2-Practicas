package main.java.ar.com.unrn.tp0.anemica;
import java.time.*;
public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }
}