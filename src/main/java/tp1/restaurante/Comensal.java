package tp1.restaurante;

public class Comensal {
    static int idComensal=0;
    private int id;
    private String name;

    public void seleccionarMesa(Mesa mesa) {
        mesa.sentarComensal(this);
    }
}
