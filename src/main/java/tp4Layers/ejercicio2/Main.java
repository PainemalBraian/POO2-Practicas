package tp4Layers.ejercicio2;

import tp4Layers.ejercicio2.infraestructura.ServicioCumpleanios;
import tp4Layers.ejercicio2.model.Empleado;
import tp4Layers.ejercicio2.model.ServicioNotificacion;
import tp4Layers.ejercicio2.servicios.AlmacenamientoArchivo;
import tp4Layers.ejercicio2.servicios.ServicioEmail;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Ruta del archivo con los empleados (ajustar segun sistema)
            String ruta = "e:/Users/Usuario/Desktop/ejemplo.txt";

            // Cargar empleados
            AlmacenamientoArchivo almacenamiento = new AlmacenamientoArchivo(ruta);
            List<Empleado> empleados = almacenamiento.cargarEmpleados();

            // Servicio de email (MailTrap)
            ServicioNotificacion servicioNotificacion = new ServicioEmail();

            // Servicio que envía saludos
            ServicioCumpleanios servicio = new ServicioCumpleanios(empleados, servicioNotificacion);

            // Ejecutar el envío
            servicio.enviarSaludos();

            System.out.println("Saludos de cumpleaños enviados.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error general: " + e.getMessage());
        }
    }
}
