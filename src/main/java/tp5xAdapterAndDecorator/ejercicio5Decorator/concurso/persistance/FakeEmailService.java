package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.ConcursoDecorator;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.EmailService;

public class FakeEmailService extends ConcursoDecorator implements EmailService {

    public FakeEmailService(Concurso concurso) {
        super(concurso);
        concurso.addEmail(this);
    }

    @Override
    public void enviarEmail(String destinatario, String asunto, String mensaje) {
        System.out.println("FakeEmail"+"\nDestinatario : " + destinatario + "\nAsunto: " + asunto + "\nMensaje: " + mensaje);
    }
}
