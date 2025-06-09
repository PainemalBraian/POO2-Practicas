package practica.pack6.backend.model;

import practica.pack6.backend.interfaces.MedioPago;

public class PagoConTransferencia implements MedioPago {
    public String procesar(double monto) {
        return "Pagado $" + monto + " con TRANSFERENCIA.";
    }
}
