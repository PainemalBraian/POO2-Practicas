package practica.pack6.backend.model;

import practica.pack6.backend.interfaces.MedioPago;

public class PagoConTarjeta implements MedioPago {
    public String procesar(double monto) {
        return "Pagado $" + monto + " con TARJETA.";
    }
}
