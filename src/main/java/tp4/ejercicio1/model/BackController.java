package tp4.ejercicio1.model;

public class BackController implements FRONTAPI {
    ParticipanteDAO participanteDAO = new ParticipanteDAO();

    public BackController() throws Exception {
    }

    @Override
    public void agregarParticipante(String nombre, String telefono, String region) throws ValidacionException {
        try {
            Participante p = new Participante(nombre, telefono, region);
            participanteDAO.updateParticipante(p);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
