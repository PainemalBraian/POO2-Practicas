package tp5xAdapterAndDecorator.ejercicio5Decorator.concurso;

public class Participante {
    private int dni;
    private String name;
    private String email;
    private int puntos;

    public Participante(int dni, String name) {
        this.dni = dni;
        this.name = name;
        this.puntos = 0;
    }
    public Participante(int dni, String name, String email) {
        this.dni = dni;
        this.name = name;
        this.email = email;
        this.puntos = 0;
    }

    public void addPuntos(int puntos) {
        this.puntos += puntos;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Participante that = (Participante) obj;
        return dni == that.dni;
    }
}
