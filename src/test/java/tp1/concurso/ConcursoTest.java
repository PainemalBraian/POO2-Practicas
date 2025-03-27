package tp1.concurso;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {

    @Test
    public void inscribirParticipanteDentroDelPlazo() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);

        // Participante
        Participante participante = new Participante(12345, "Juan Perez");

        // Inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.inscribirParticipante(participante,concurso);

        // Verificar inscripción
        assertTrue(concurso.existParticipante(participante));
    }

    @Test
    public void inscribirParticipantePrimerDiaDeApertura() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);

        // Participante
        Participante participante = new Participante(54321, "Ana Martinez");

        // Inscripción
        Inscripcion inscripcion = new Inscripcion();
        inscripcion.inscribirParticipante(participante,concurso);

        // Verificar inscripción y puntos
        assertTrue(concurso.existParticipante(participante));
        assertEquals(10, participante.getPuntos()); // Ganó puntos por inscribirse el primer día
    }

    @Test
    public void inscribirParticipanteFueraDelPlazo() {
        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(20); // Fecha pasada
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite);

        // Participante
        Participante participante = new Participante(98765, "Pedro Meza");

        // Intento de inscripción
        Inscripcion inscripcion = new Inscripcion();
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            inscripcion.inscribirParticipante(participante,concurso); });

        // Verificar mensaje de error
        assertEquals(Inscripcion.FUERA_DE_PLAZO, exception.getMessage());
    }
}

//  Luego de implementar escriba los siguientes casos de test:
//  1. Un participante se inscribe en un concurso
//  2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
//  3. Un participante intenta inscribirse fuera del rango de inscripción.
//
//  Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones relacionadas con la fecha.
//  Lograr alta cobertura (mayor a 90%). Verifique si quedan funcionalidades sin testear.