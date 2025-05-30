package practica.pack4;

public class NotificacionEmail implements CanalDeNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[EMAIL] " + mensaje);
    }
}
