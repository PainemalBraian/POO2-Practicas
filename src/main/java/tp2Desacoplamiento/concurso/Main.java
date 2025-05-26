package tp2Desacoplamiento.concurso;
import tp2Desacoplamiento.concurso.persistance.AlmacenamientoBaseDatosConcurso;
import tp2Desacoplamiento.concurso.persistance.EmailServiceImplement;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Usar base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosConcurso();
        EmailServiceImplement emailServiceImplement = new EmailServiceImplement();

        // Configurar Concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, almacenamientoBaseDatos, emailServiceImplement);

        // Inscribir participante
        Participante participante = new Participante(12345, "Juan Perez","emailejemplo@gmail.com");
        var participante2 = new Participante(54321, "Martín Ramos");
        concurso.inscribirParticipante(participante);
        //concurso.inscribirParticipante(participante2);
    }
}