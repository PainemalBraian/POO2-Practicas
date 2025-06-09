package practica.pack6.frontend;

import practica.pack6.backend.model.PagoConTarjeta;
import practica.pack6.backend.exception.PagoFallidoException;
import practica.pack6.backend.services.ServicioPagos;

public class Main {
    public static void main(String[] args) {
        try {
            ServicioPagos servicio = new ServicioPagos(new PagoConTarjeta());
            System.out.println(servicio.realizarPago(500.0));
        } catch (PagoFallidoException e) {
            System.out.println(e.getMessage());
        }
    }
}
