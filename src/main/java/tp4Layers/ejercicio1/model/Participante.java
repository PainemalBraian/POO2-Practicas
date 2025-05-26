package tp4Layers.ejercicio1.model;

public class Participante {
    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region) throws ValidacionException {
        if (nombre == null || nombre.isBlank())
        throw new ValidacionException("Debe cargar un nombre");
        if (telefono == null || telefono.isBlank())
        throw new ValidacionException("Debe cargar un telefono");
        if (!validarTelefono(telefono))
        throw new ValidacionException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa"))
        throw new ValidacionException("Región desconocida. Las conocidas son: China, US, Europa");

        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }
    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }

    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getRegion() { return region; }
}

