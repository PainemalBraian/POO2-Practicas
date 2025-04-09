package tp2.concurso;
import tp2.concurso.persistance.AlmacenamientoBaseDatosConcurso;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Usar base de datos
        Almacenamiento almacenamientoBaseDatos = new AlmacenamientoBaseDatosConcurso();

        // Configurar Concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, almacenamientoBaseDatos);

        // Inscribir participante
        Participante participante = new Participante(12345, "Juan Perez");
        var participante2 = new Participante(54321, "Martín Ramos");
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);
    }
}