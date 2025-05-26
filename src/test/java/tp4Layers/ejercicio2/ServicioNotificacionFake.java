package tp4Layers.ejercicio2;

import tp4Layers.ejercicio2.model.ServicioNotificacion;

import java.util.ArrayList;
import java.util.List;

public class ServicioNotificacionFake implements ServicioNotificacion {

    public static class Correo {
        public final String destinatario, asunto, mensaje;
        public Correo(String destinatario, String asunto, String mensaje) {
            this.destinatario = destinatario;
            this.asunto = asunto;
            this.mensaje = mensaje;
        }
    }

    private final List<Correo> enviados = new ArrayList<>();

    @Override
    public void enviar(String destinatario, String asunto, String mensaje) {
        enviados.add(new Correo(destinatario, asunto, mensaje));
    }

    public List<Correo> getEnviados() {
        return enviados;
    }
}