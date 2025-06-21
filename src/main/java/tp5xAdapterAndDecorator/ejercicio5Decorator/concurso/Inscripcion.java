package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso;

import java.time.LocalDate;

public class Inscripcion {
    static int idInscripcion=0;
    private int id;
    private Participante participante;
    private ConcursoBase concurso;
    private LocalDate fechaInscripcion;

    public Inscripcion(Participante participante, ConcursoBase concurso) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion = LocalDate.now();    //Se podría considerar implementar un exception por fecha limite
        this.id = idInscripcion++;
    }

    public static int getIdInscripcion() {
        return idInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public boolean isInscripcionParticipante(Participante p) {
        return this.participante.equals(p);
    }

}
