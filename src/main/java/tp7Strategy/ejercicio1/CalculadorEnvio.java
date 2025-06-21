package tp7Strategy.ejercicio1;

public class CalculadorEnvio {
    private EnvioStrategy strategy;
    
    public CalculadorEnvio(EnvioStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void setStrategy(EnvioStrategy strategy) {
        this.strategy = strategy;
    }
    
    public double calcularCostoEnvio(String destino, double pesoTotal) {
        return strategy.calcularCostoEnvio(destino, pesoTotal);
    }
}