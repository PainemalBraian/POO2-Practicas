package practica.pack6.backend.fake;

import practica.pack6.backend.interfaces.MedioPago;

public class FakePago implements MedioPago {
    double monto;
    @Override
    public String procesar(double monto) {
        this.monto = monto;
        return "Pagado $" + monto + " con Fake.";
    }
    public double monto(){
        return monto;
    }
}
