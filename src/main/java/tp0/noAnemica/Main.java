package tp0.noAnemica;

import java.time.format.*;

public class Main{
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();

        // Formato largo
        String formatoLargo = tiempo.getFecha().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        System.out.println("Fecha en formato largo: " + formatoLargo);

        // Formato corto
        String formatoCorto = tiempo.getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Fecha en formato corto: " + formatoCorto);
    }
/*
    Este enfoque No Anémico, la clase Tiempo expone su atributo "fecha" mediante un getter,
    permitiendo que cualquier otra clase acceda y manipule directamente la información sin restricciones.

    Por ello la lógica de formateo de fecha no está dentro de la clase "Tiempo", sino que se implementó
    directamente en el Main. Esto rompe el principio de encapsulamiento, ya que "Main" ahora tiene la
    responsabilidad de interpretar y manipular los datos en lugar de delegar esa tarea al propio objeto "Tiempo".

    Este diseño puede llevar a una dispersión de lógica, donde múltiples partes del código se encargan
    de operar sobre los datos, en lugar de centralizar el comportamiento dentro del propio objeto.
*/

}