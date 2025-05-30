package practica.pack1;

public class Express implements TipoEnvio{
    private String tipo = "Express";
    private static final int costo = 150;
    private static final int recargo = 500;

    public Express() {
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
