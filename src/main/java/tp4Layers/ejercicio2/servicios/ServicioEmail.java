package tp4Layers.ejercicio2.servicios;

import tp4Layers.ejercicio2.model.ServicioNotificacion;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class ServicioEmail implements ServicioNotificacion {
    private final String usuario = "34110542ff1e26"; // usuario de Mailtrap
    private final String contrasena = "025dc737c44d11"; // contraseña de Mailtrap
//    private final String host = "smtp.mailtrap.io";
//    private final int puerto = 2525;

    @Override
    public void enviar(String destinatario, String asunto, String mensaje) {
        System.out.println("Enviando correo a: " + destinatario);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);

        // Configuración del servidor SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.mailtrap.io");
        propiedades.put("mail.smtp.port", "2525");

        // Crear una sesión con autenticación
        Session session = Session.getInstance(propiedades, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contrasena);
            }
        });

        try {
            // Construir el mensaje
            Message correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress("noreply@cumpleanos.com")); // Dirección del remitente
            correo.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario)); // Destinatario
            correo.setSubject(asunto); // Asunto
            correo.setText(mensaje); // Cuerpo del mensaje

            // Enviar el correo
            Transport.send(correo);
        } catch (MessagingException e) {
            throw new RuntimeException("Error al enviar el correo: " + e.getMessage(), e);
        }
    }
}

