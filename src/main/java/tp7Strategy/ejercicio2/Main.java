package tp7Strategy.ejercicio2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var fechaNacimiento = LocalDate.of(1990, 5, 15);
        var persona = new Persona(fechaNacimiento, new fechaCorta());

        System.out.println(persona.fechaNacimiento());
    }
}