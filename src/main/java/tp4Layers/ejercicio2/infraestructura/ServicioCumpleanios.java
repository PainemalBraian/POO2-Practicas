package tp4Layers.ejercicio2.infraestructura;

import tp4Layers.ejercicio2.model.Empleado;
import tp4Layers.ejercicio2.model.ServicioNotificacion;
import java.util.List;

public class ServicioCumpleanios {
    private List<Empleado> empleados;
    private ServicioNotificacion servicioNotificacion;

    public ServicioCumpleanios(List<Empleado> empleados, ServicioNotificacion servicioNotificacion) {
        this.empleados = empleados;
        this.servicioNotificacion = servicioNotificacion;
    }

    public void enviarSaludos() {
        for (Empleado empleado : empleados) {
            if (empleado.esCumpleaniosHoy()) {
                String mensaje = "Feliz cumpleaños, " + empleado.getNombre() + "!";
                System.out.println(mensaje);
                servicioNotificacion.enviar(empleado.getEmail(), "Feliz Cumpleaños", mensaje);
            }
        }
    }
}

