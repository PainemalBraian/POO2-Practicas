package src.main.java.ar.com.unrn.tp0.noAnemico;
import java.time.*;
public class Tiempo {
    private LocalDate fecha;

    public Tiempo(){
        this.fecha = LocalDate.now();
    }
    public String obtenerFechaLarga() {
        SimpleDateFormat formatoLargo = new SimpleDateFormat("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        Date fechaActual = new Date();
        return formatoLargo.format(fechaActual);
    }
    public String obtenerFechaCorta() {
        SimpleDateFormat formatoCorto = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaActual = new Date();
        return formatoCorto.format(fechaActual);
    }
}

