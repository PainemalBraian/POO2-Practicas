import java.time.*;
public class tiempo {
    private LocalDate fecha;

    public tiempo(){
        this.fecha = LocalDate.now();
    }

    public LocalDate getFecha() {
        return fecha;
    }
}