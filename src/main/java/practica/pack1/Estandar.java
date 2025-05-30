package practica.pack1;

public class Estandar implements TipoEnvio{
    private String tipo = "Estandar";
    private static final int costo = 100;
    private static final int recargo = 0;

    public Estandar() {
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
