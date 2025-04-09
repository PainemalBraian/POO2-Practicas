package tp2.concurso;
import tp2.concurso.persistance.AlmacenamientoBaseDatosConcurso;
import tp2.concurso.persistance.EmailService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Usar base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosConcurso();
        EmailService emailService = new EmailService();

        // Configurar Concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, almacenamientoBaseDatos,emailService);

        // Inscribir participante
        Participante participante = new Participante(12345, "Juan Perez","emailejemplo@gmail.com");
        var participante2 = new Participante(54321, "Martín Ramos");
        concurso.inscribirParticipante(participante);
        //concurso.inscribirParticipante(participante2);
    }
}