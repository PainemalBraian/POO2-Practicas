package tp7Strategy.ejercicio3;

public class CalculadorBase implements CalculadorDePrecios {
    @Override
    public double calcularPrecioFinal(TipoProducto tipo) {
        double total = tipo.precio() * (1 + tipo.impuesto()) * (1 - tipo.descuento());
        if (tipo.envioGratis()) {
            total -= 10;
        }
        return total;
    }
}
