package practica.pack4;

public class NotificadorEventos {
    private CanalDeNotificacion canal;

    public NotificadorEventos(CanalDeNotificacion canal) {
        // Validar Canal not null
        this.canal = canal;
    }

    public void enviarMensaje(String mensaje){
        // Validar mensaje no vacio ni null
        canal.enviar(mensaje);
    }

}
