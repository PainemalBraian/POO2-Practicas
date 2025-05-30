package practica.pack5.backend.model;

// Modelo
public class Tarea {
    private String descripcion;
    private boolean completada;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
        this.completada = false;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean estaCompletada() {
        return completada;
    }

    @Override
    public String toString() {
        return (completada ? "[X] " : "[ ] ") + descripcion;
    }
}
