package tp4.ejercicio2.servicios;

import tp4.ejercicio2.model.Empleado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AlmacenamientoArchivo {
    private String rutaArchivo;

    public AlmacenamientoArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public List<Empleado> cargarEmpleados() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String apellido = datos[0].trim();
                String nombre = datos[1].trim();
                LocalDate fechaNacimiento = LocalDate.parse(datos[2].trim());
                String email = datos[3].trim();
                empleados.add(new Empleado(apellido, nombre, fechaNacimiento, email));
            }
        }
        return empleados;
    }
}

