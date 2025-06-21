package tp7Strategy.ejercicio2;


import java.time.LocalDate;

public class Persona {
    private FechaNacimiento formatoFecha;
    private LocalDate fechaNacimiento;

    public Persona (LocalDate fechaNacimiento, FechaNacimiento formatoFecha) {
        this.fechaNacimiento = fechaNacimiento;
        this.formatoFecha = formatoFecha;
    }
    public String fechaNacimiento() {
        return formatoFecha.getFecha(fechaNacimiento);
    }

}
