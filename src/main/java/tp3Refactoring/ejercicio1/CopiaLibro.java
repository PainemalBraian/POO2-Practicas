package tp3Refactoring.ejercicio1;

public class CopiaLibro {
    private Libro libro;

    public CopiaLibro(Libro libro) {
        this.libro = libro;
    }

    public Libro obtenerCopiaLibro() {
        return libro;
    }
}