package main.java.ar.com.unrn.tp0.anemico;

public class Main {
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();
        System.out.println("Fecha en formato largo: " + tiempo.obtenerFechaLarga());
        System.out.println("Fecha en formato corto: " + tiempo.obtenerFechaCorta());
    }

    /*
    Esta implementación anémica, utiliza la clase Tiempo como un contenedor de datos,
    sin incorporar lógica de cálculo o de negocio.

    Aunque se nota que usa métodos para formatear la fecha, su única responsabilidad es devolver la información
    , sin tomar decisiones o realizar cálculos complejos.

    Este enfoque sigue el patrón de "Modelo Anémico", donde la lógica queda separada de los datos
*/

}
