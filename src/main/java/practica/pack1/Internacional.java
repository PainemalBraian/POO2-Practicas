package practica.pack1;

public class Internacional implements TipoEnvio{
    private String tipo = "Internacional";
    private static final int costo = 300;
    private static final int recargo = 1000;

    public Internacional() {
    }

    @Override
    public String tipo() {
        return this.tipo;
    }

    @Override
    public int costo() {
        return costo;
    }

    @Override
    public int recargo() {
        return recargo;
    }
}
