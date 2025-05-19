package tp4.ejercicio2.model;

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
        MonthDay hoy = MonthDay.now();
        return MonthDay.from(fechaNacimiento).equals(hoy);
    }
}
