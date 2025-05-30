package practica.pack4;

import java.util.ArrayList;
import java.util.List;

public class FakeCanalNotificacion implements  CanalDeNotificacion{
    private List<String> notificaciones = new ArrayList<>();

    public FakeCanalNotificacion() {
    }

    public void addMensaje(String mensaje) {
        notificaciones.add(mensaje);
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("[FAKE] " +mensaje);
        addMensaje(mensaje);
    }

    public String notificaciones(){
        StringBuffer contenido= new StringBuffer();
        for (String mensaje : notificaciones) {
            contenido.append(mensaje);
            contenido.append("\n");
        }
        System.out.println(contenido);
        return String.valueOf(contenido);
    }
}
