package practica.pack1;

public class Envio{
    static final String PESO_VALIDACION = "El peso debe ser mayor a 0";
    static final String TIPO_DE_ENVÍO_VALIDACION = "El tipo de envío debe ser válido";
    static final String SERVICIO_DE_REGISTRO_VALIDACION = "El servicio de Registro de envío debe ser válido";

    private double peso;
    private TipoEnvio tipoEnvio;
    private RegistroEnvio registroEnvio;

    public Envio(double peso, TipoEnvio tipoEnvio) throws EnvioException {
        if (peso <= 0) {
            throw new EnvioException(PESO_VALIDACION);
        }
        if (tipoEnvio == null) {
            throw new EnvioException(TIPO_DE_ENVÍO_VALIDACION);
        }
        this.peso = peso;
        this.tipoEnvio = tipoEnvio;
    }

    public double calcularCosto() {
        return  peso * tipoEnvio.costo() +tipoEnvio.recargo();
    }

    public void registrar(RegistroEnvio registroEnvio) throws EnvioException {
        if (registroEnvio == null) {
            throw new EnvioException(SERVICIO_DE_REGISTRO_VALIDACION);
        }
        this.registroEnvio = registroEnvio; // en caso de querer persistir la entidad con el tipo de servicio usado
        registroEnvio.registrar(this);
    }

    public double peso() {
        return peso;
    }

    public TipoEnvio getTipoEnvio() {
        return tipoEnvio;
    }

    public RegistroEnvio getRegistroEnvio() {
        return registroEnvio;
    }
}
