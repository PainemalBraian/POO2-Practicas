package practica.pack6.backend.services;

import practica.pack6.backend.exception.PagoFallidoException;
import practica.pack6.backend.interfaces.MedioPago;

public class ServicioPagos {
    public static final String PAGO_VALIDACION = "El monto debe ser mayor a cero.";
    private MedioPago medio;

    public ServicioPagos(MedioPago medio) {
        this.medio = medio;
    }

    public String realizarPago(double monto) throws PagoFallidoException {
        if (monto <= 0) {
            throw new PagoFallidoException(PAGO_VALIDACION);
        }
        return medio.procesar(monto);
    }
}
