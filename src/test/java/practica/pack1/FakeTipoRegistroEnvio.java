package practica.pack1;

public class FakeTipoRegistroEnvio implements RegistroEnvio{
    private String detalle;

    public FakeTipoRegistroEnvio() {
    }


    @Override
    public void registrar(Envio envio) {
        this.detalle =
                "Costo Total: " + String.valueOf(envio.calcularCosto())+"\n"+
                        "Peso: " + envio.peso()+"\n"+
                        "Tipo Envio: " + envio.getTipoEnvio().tipo()+"\n"+
                        "Costo: " + envio.getTipoEnvio().costo()+"\n"+
                        "Recargo: " + envio.getTipoEnvio().recargo();
    }

    @Override
    public String detalle() {
        return detalle;
    }

}
