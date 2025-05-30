package practica.pack4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotificadorTest {
    @Test
    public void emailEnviarTest(){
        var notificador = new NotificadorEventos(new NotificacionEmail());
        notificador.enviarMensaje("Holaa");
//        assertEquals("[EMAIL] Holaa",notificador.enviarMensaje("Holaa"));
    }
    @Test
    public void whatsAppEnviarTest(){
        var notificador = new NotificadorEventos(new NotificacionWhatsApp());
        notificador.enviarMensaje("Holaa");
//        assertEquals("[EMAIL] Holaa",notificador.enviarMensaje("Holaa")); assert no posible, a menos que se simule el servicio de obtencion del contenido desde el canal usado o tal vez un assertTrue del funcionamiento?
    }
    @Test
    public void fakeEnviarTest(){
        var canalFake = new FakeCanalNotificacion();
        var notificador = new NotificadorEventos(canalFake);
        notificador.enviarMensaje("Holaa");
        notificador.enviarMensaje("Adioos");

        assertEquals("Holaa\nAdioos\n",canalFake.notificaciones());
    }
}
