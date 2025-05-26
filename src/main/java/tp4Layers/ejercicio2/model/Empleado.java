package tp4Layers.ejercicio2.model;

import java.time.LocalDate;
import java.time.MonthDay;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;

    public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public boolean esCumpleaniosHoy() {
//        return true; // Forzar true para evitar la necesidad de cargar la "fecha de cumpleaños" en el dia actual en el archivo
        MonthDay hoy = MonthDay.now(); // obtiene el mes y día actuales, sin importar el año
        return MonthDay.from(fechaNacimiento).equals(hoy); // compara solo mes y día de nacimiento
    }

}
