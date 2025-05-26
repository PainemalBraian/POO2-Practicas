package tp2Desacoplamiento.concurso;

public interface EmailService {
    void enviarEmail(String destinatario, String asunto, String mensaje);
}
