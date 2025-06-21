package tp7Strategy.ejercicio3;

public class Producto {
    public TipoProducto tipo;
    private CalculadorDePrecios strategy;

    public Producto(TipoProducto tipo, CalculadorDePrecios strategy) {
        this.tipo = tipo;
        this.strategy = strategy;
    }

    public double precioFinal() {
        return strategy.calcularPrecioFinal(tipo);
    }
}
