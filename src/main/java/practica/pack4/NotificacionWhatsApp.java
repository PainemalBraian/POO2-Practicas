package practica.pack4;

public class NotificacionWhatsApp implements CanalDeNotificacion {
    @Override
    public void enviar(String mensaje) {
        System.out.println("[WHATSAPP] " + mensaje);
    }
}