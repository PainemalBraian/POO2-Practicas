package tp4Layers.ejercicio1.model;

public interface FRONTAPI {
    void agregarParticipante(String nombre, String telefono, String region) throws ValidacionException;
}
