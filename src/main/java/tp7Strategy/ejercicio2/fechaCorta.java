package tp7Strategy.ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class fechaCorta implements FechaNacimiento {

    public String getFecha(LocalDate fechaNacimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaNacimiento.format(formato);
    }
}