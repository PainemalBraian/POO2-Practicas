package tp2.concurso;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ConcursoTest {
    static String DIRECTORIO ="C:\\Users\\braia\\Downloads\\tmp\\Objetos 2\\inscripciones.txt";

    @Test
    public void inscribirParticipanteDentroDelPlazo() throws IOException {
        // Crear archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorArchivoDocumento(directorio.toString());

        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(2);
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite, escritorArchivo);

        // Participante
        Participante participante = new Participante(12345, "Juan Perez");
        Participante participante2 = new Participante(54321, "Martín Ramos");

        // Inscripción
        concurso.inscribirParticipante(participante);
        concurso.inscribirParticipante(participante2);

        // Verificar inscripción
        assertTrue(concurso.existParticipante(participante));
    }

    @Test
    public void inscribirParticipantePrimerDiaDeApertura() {
        // Uso del archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);
        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorArchivoDocumento(directorio.toString());

        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now();
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite,escritorArchivo);

        // Participante
        Participante participante = new Participante(54321, "Ana Martinez");

        // Inscripción
        concurso.inscribirParticipante(participante);

        // Verificar inscripción y puntos
        assertTrue(concurso.existParticipante(participante));
        assertEquals(10, participante.getPuntos()); // Ganó puntos por inscribirse el primer día
    }

    @Test
    public void inscribirParticipanteFueraDelPlazo() {
        // Uso del archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);
        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorArchivoDocumento(directorio.toString());

        // Configuración del concurso
        LocalDate fechaApertura = LocalDate.now().minusDays(20); // Fecha pasada
        LocalDate fechaLimite = fechaApertura.plusDays(10);
        Concurso concurso = new Concurso(fechaApertura, fechaLimite,escritorArchivo);

        // Participante
        Participante participante = new Participante(98765, "Pedro Meza");

        // Intento de inscripción
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            concurso.inscribirParticipante(participante); });

        // Verificar mensaje de error fuera de plazo
        assertEquals(Concurso.FUERA_DE_PLAZO, exception.getMessage());
    }
}