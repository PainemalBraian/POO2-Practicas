package tp7Strategy.ejercicio2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class fechaLarga implements FechaNacimiento {

    @Override
    public String getFecha(LocalDate fechaNacimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy");
        return fechaNacimiento.format(formato);
    }
}