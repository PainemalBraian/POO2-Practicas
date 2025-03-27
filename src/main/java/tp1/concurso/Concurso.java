package tp1.concurso;

import java.time.LocalDate;
import java.util.ArrayList;

public class Concurso {
    static int idConcurso=0;
    private int id;
    private LocalDate fechaApertura;
    private LocalDate fechaLimite;
    private ArrayList<Inscripcion> inscriptos;

    public Concurso(LocalDate fechaApertura, LocalDate fechaLimite, ArrayList<Inscripcion> inscriptos) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        this.inscriptos = inscriptos;
    }

    public Concurso(LocalDate fechaApertura, LocalDate fechaLimite) {
        this.id = idConcurso++;
        this.fechaApertura = fechaApertura;
        this.fechaLimite = fechaLimite;
        inscriptos=null;
    }

    public int getId() {
        return id;
    }

    void agregarInscripcion(Inscripcion i) {
        this.inscriptos.add(i);
    }

    public boolean estaDentroDelPlazo(LocalDate fecha) {
        return fecha.isBefore(fechaLimite);
    }

    public boolean esFechaDeApertura() {
        return LocalDate.now().isEqual(fechaApertura);
    }

    public String obtenerPuntosParticipante(Participante p) {
        for (Inscripcion i: inscriptos)
                if (i.isInscripcionParticipante(p))
                        return p.obtenerPuntos();
        return null; //Se podria mejorar implementando el uso de exceptions
    }

    public boolean existParticipante(Participante p) {
        for (Inscripcion i: inscriptos)
            if (i.isInscripcionParticipante(p))
                return true;
        return false;
    }
}

//  Implemente un sistema de Concursos, donde los participantes pueden inscribirse para participar de los mismos.
//  El participante debe poder inscribirse a los concursos.
//  El concurso acepta la inscripción solo dentro del rango de fecha de inscripción.
//  El participante gana 10 puntos si se inscribe durante el primer día de abierta la inscripción.

//  Dado un participante se puede conocer la cantidad de puntos ganados.
//  Si un participante intenta inscribirse fuera de la fecha de inscripción se debe informar con un mensaje.

//  Luego de implementar escriba los siguientes casos de test:
//  1. Un participante se inscribe en un concurso
//  2. Un participante se inscribe en un concurso el primer día de abierta la inscripción.
//  3. Un participante intenta inscribirse fuera del rango de inscripción.
//
//  Importante: Tener en cuenta el paso del tiempo en aquellos tests que verifican cuestiones relacionadas con la fecha.
//  Lograr alta cobertura (mayor a 90%). Verifique si quedan funcionalidades sin testear.



// TEST no debe crear ninguna instancia de los objetos de servicio
// solo deben comunicarse con los de negocio/dominio, para eso se crean objetos "fake" en TEST que implementan la clase abstracta y proporcionan los metodos requeridos
//


// dependencia

// implements


//  Generar archivo de texto (clase files). Investigar crear archivos en Java
//  como desacoplar clase files de tp1.concurso.concurso a traves de abstracción, ej: con un metodo exportar de otra clase usada por una interface
//  Concurso no debe tener implementación de exportar.



//  una linea cada que un participante se inscribe
//  Ej: Según cada entradas, deben crear un archivo independiente para cada uno


//  crear interface con meotodo abstracto, para que una clase la implemente
//  tp1.concurso.concurso debe estar enlazado a algo abstracto (la interface)
