package main.java.ar.com.unrn.tp0.noAnemico;
public class Main {
    public static void main(String[] args) {
        Tiempo tiempo = new Tiempo();

        // Lógica delegada en la clase Tiempo
        System.out.println("Fecha en formato largo: " + tiempo.obtenerFechaLarga());
        System.out.println("Fecha en formato corto: " + tiempo.obtenerFechaCorta());
    }
}
