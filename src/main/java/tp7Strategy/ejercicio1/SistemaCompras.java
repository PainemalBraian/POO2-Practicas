package tp7Strategy.ejercicio1;

public class SistemaCompras {
    private CarritoCompras carrito = new CarritoCompras();
    private CalculadorEnvio calculadorEnvio;
    
    public SistemaCompras() {}
    
    public void agregarProducto(Producto producto) {
        carrito.agregarProducto(producto);
    }
    
    public void seleccionarFormaEnvio(EnvioStrategy strategy) {
        this.calculadorEnvio = new CalculadorEnvio(strategy);
    }
    
    public double calcularCostoTotal(String destino) {
        if (calculadorEnvio == null) {
            throw new RuntimeException("Debe seleccionar una forma de envío");
        }
        
        double precioProductos = carrito.calcularPrecioTotal();
        double pesoTotal = carrito.calcularPesoTotal();
        double costoEnvio = calculadorEnvio.calcularCostoEnvio(destino, pesoTotal);
        
        return precioProductos + costoEnvio;
    }
    public double obtenerCostoEnvio(String destino) {
        if (calculadorEnvio == null) {
            throw new RuntimeException("Debe seleccionar una forma de envío");
        }
        return calculadorEnvio.calcularCostoEnvio(destino, carrito.calcularPesoTotal());
    }
}
    