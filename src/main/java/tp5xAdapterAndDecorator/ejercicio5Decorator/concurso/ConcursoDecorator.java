package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Almacenamiento;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.EmailService;

public abstract class ConcursoDecorator implements Concurso {
    private Concurso concurso;

    public ConcursoDecorator(Concurso concurso) {
        this.concurso = concurso;
    }

    @Override
    public void inscribirParticipante(Participante p) {
        concurso.inscribirParticipante(p);
    }

    @Override
    public void addAlmacenamiento(Almacenamiento almacenamiento) {
        concurso.addAlmacenamiento(almacenamiento);
    }

    @Override
    public void addEmail(EmailService emailService) {
        concurso.addEmail(emailService);
    }

}
