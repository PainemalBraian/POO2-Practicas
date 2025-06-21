package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso;

import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Almacenamiento;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.Concurso;
import tp5xAdapterAndDecorator.ejercicio5Decorator.concurso.interfaces.EmailService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ConcursoBase implements Concurso {
    static String FUERA_DE_PLAZO = "No se puede inscribir, ya que la fecha de inscripción ha expirado.";
    static int idConcurso=0;
    private int id;
    private LocalDate fechaApertura;
    private LocalDate fechaLimite;
    private ArrayList<Inscripcion> inscriptos;

    private Almacenamiento almacenamiento;
    private EmailService emailService;

    public ConcursoBase(LocalDate fechaApertura, LocalDate fechaLimite) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        this.inscriptos=new ArrayList<>();
    }

    @Override
    public void addAlmacenamiento(Almacenamiento almacenamiento){
        this.almacenamiento = almacenamiento;
    }

    @Override
    public void addEmail(EmailService emailService){
        this.emailService = emailService;
    }

    @Override
    public void inscribirParticipante(Participante p){
        if (estaDentroDelPlazo(LocalDate.now())){
            Inscripcion nuevaInscripcion = new Inscripcion(p,this);
            agregarInscripcion(nuevaInscripcion);
            if (almacenamiento != null)
                guardarEnArchivo(nuevaInscripcion); // Uso de la abstracción para guardar en archivo

            // Enviar correo al participante
            String asunto = "Inscripción confirmada";
            String mensaje = "Hola " + p.getName() + ",\n\n" +
                    "Te confirmamos que te has inscrito con éxito al concurso ID: " + this.id + ".\n" +
                    "¡Buena suerte!\n\n" +
                    "Saludos,\nEquipo del Concurso";
            if (emailService != null)
                emailService.enviarEmail(p.getEmail(), asunto, mensaje);

            if (esFechaDeApertura())
                p.addPuntos(10);
        }else {
            throw new RuntimeException(FUERA_DE_PLAZO);
        }
    }

    private void guardarEnArchivo(Inscripcion inscripcion) {
        String formatoFecha = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaInscripcion = inscripcion.getFechaInscripcion().format(formatter);
        String linea = "Fecha de Inscripción: " + fechaInscripcion +
                //"\nID Inscripción: " + inscripcion.getIdInscripcion() +
                "\nID Concurso: " + this.id+
                "\nFecha Límite: " + fechaLimite.format(formatter) +
                "\nFecha Apertura: "+fechaApertura.format(formatter)+"\n";

        almacenamiento.guardarInscripcion(linea);
    }

    private void agregarInscripcion(Inscripcion i) {
        this.inscriptos.add(i);
    }

    private boolean estaDentroDelPlazo(LocalDate fecha) {
        return fecha.isBefore(fechaLimite);
    }

    private boolean esFechaDeApertura() {
        return LocalDate.now().isEqual(fechaApertura);
    }

    private boolean existParticipante(Participante p) {
        for (Inscripcion i: inscriptos)
            if (i.isInscripcionParticipante(p))
                return true;
        return false;
    }
}