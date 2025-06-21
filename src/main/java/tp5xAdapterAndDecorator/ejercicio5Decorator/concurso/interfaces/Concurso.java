package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.Participante;

public interface Concurso {
    void inscribirParticipante(Participante p);
    void addAlmacenamiento(Almacenamiento almacenamiento);
    void addEmail(EmailService emailService);
}
