package practica.pack2;

public class DescuentoEstandar implements TipoDescuento{
    private double descuento = 0.2; //20%

    public DescuentoEstandar() {
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double descuento(){
        return this.descuento;
    }
}
