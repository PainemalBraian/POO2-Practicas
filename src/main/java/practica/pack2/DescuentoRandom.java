package practica.pack2;

import java.util.Random;

public class DescuentoRandom implements TipoDescuento{
    private double descuento = (new Random().nextInt(30) + 1) / 100d;

    @Override
    public double descuento(){
        return this.descuento;
    }
}
