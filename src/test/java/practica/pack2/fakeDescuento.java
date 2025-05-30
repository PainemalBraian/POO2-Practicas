package practica.pack2;

public class fakeDescuento implements TipoDescuento{
    double descuento = -1;

    @Override
    public double descuento() {
        return 0;
    }
}
