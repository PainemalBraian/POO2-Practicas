package tp1.restaurante;

public class Comensal {
    private int dni;
    private String name;

    public Comensal(int dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public void seleccionarMesa(Mesa mesa) {
        mesa.sentarComensal(this);
    }
}
