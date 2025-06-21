package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.ConcursoDecorator;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.EmailService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailServiceImplement extends ConcursoDecorator implements EmailService {
    private final String username = "34110542ff1e26"; // usuario de Mailtrap
    private final String password = "025dc737c44d11"; // contraseña de Mailtrap

    public EmailServiceImplement(Concurso concurso) {
        super(concurso);
        concurso.addEmail(this);
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String mensaje) {
        // Configuración del servidor SMTP
        Properties propiedades = new Properties();
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");
        propiedades.put("mail.smtp.host", "smtp.mailtrap.io");
        propiedades.put("mail.smtp.port", "2525");

        // Crear una sesión con autenticación
        Session session = Session.getInstance(propiedades, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Construir el mensaje
            Message correo = new MimeMessage(session);
            correo.setFrom(new InternetAddress("noreply@concurso.com")); // Dirección del remitente
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
