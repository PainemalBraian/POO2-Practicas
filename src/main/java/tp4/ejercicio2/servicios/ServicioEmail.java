package tp4.ejercicio2.servicios;

import tp4.ejercicio2.model.ServicioNotificacion;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class ServicioEmail implements ServicioNotificacion {
    private final String usuario = "TU_USUARIO_MAILTRAP";
    private final String contrasena = "TU_CONTRASEÑA_MAILTRAP";
    private final String host = "smtp.mailtrap.io";
    private final int puerto = 587;

    @Override
    public void enviar(String destinatario, String asunto, String mensaje) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", puerto);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contrasena);
            }
        });

        try {
            Message email = new MimeMessage(session);
            email.setFrom(new InternetAddress("noreply@empresa.com"));
            email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            email.setSubject(asunto);
            email.setText(mensaje);

            Transport.send(email);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

