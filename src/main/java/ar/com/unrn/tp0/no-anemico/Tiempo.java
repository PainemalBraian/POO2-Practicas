import java.time.*;
public class tiempo {
    private LocalDate fecha;

    public tiempo(){
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

