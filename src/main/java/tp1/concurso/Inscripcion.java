package tp1.concurso;

import java.time.LocalDate;
import java.util.Objects;

public class Inscripcion {
    static String FUERA_DE_PLAZO = "No se puede inscribir, ya que la fecha de inscripción ha expirado.";
    static int idInscripcion=0;
    private int id;
    private Participante participante;
    private Concurso concurso;
    private LocalDate fechaInscripcion;

    public Inscripcion() {
    }
    public Inscripcion(Participante participante, Concurso concurso) {
        this.participante = participante;
        this.concurso = concurso;
        this.fechaInscripcion = LocalDate.now();    //Se podría considerar implementar un exception por fecha limite
        this.id = idInscripcion++;
    }

    public int getId() {
        return id;
    }

    public void inscribirParticipante(Participante p, Concurso c){
        if (c.estaDentroDelPlazo(LocalDate.now())){
            c.agregarInscripcion(new Inscripcion(p,c));
            if (c.esFechaDeApertura())
                p.addPuntos(10);
        }else {
            throw new RuntimeException(FUERA_DE_PLAZO);
        }
    }

    public boolean isInscripcionParticipante(Participante p) {
        return this.participante.equals(p);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(concurso,participante);
//    }
}
