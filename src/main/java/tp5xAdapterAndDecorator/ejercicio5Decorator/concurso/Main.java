package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance.FakeArchivoEnConsola;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.persistance.FakeEmailService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Configurar Concurso
        var fechaApertura = LocalDate.now();
        var fechaLimite = fechaApertura.plusDays(10);
        var concurso = new FakeArchivoEnConsola(
                new FakeEmailService(
                        new ConcursoBase(fechaApertura, fechaLimite)));

        // Inscribir participante
        var participante = new Participante(12345, "Juan Perez","emailejemplo@gmail.com");
        var participante2 = new Participante(54321, "Martín Ramos","asd@hotmail.com");

        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);
    }
}