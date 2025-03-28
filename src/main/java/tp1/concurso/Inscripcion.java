package tp1.concurso;

import java.time.LocalDate;
import java.util.Objects;

public class Inscripcion {
    static int idInscripcion=0;
    private int id;
    private Participante participante;
    private Concurso concurso;
    private LocalDate fechaInscripcion;

    public Inscripcion(Participante participante, Concurso concurso) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion = LocalDate.now();    //Se podría considerar implementar un exception por fecha limite
        this.id = idInscripcion++;
    }

    public boolean isInscripcionParticipante(Participante p) {
        return this.participante.equals(p);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(concurso,participante);
//    }
}
