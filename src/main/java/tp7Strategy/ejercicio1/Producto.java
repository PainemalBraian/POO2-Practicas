package tp7Strategy.ejercicio1;

public class Producto {
    private String nombre;
    private double precio;
    private double peso; // en kg
    
    public Producto(String nombre, double precio, double peso) {
        this.nombre = nombre;
        this.precio = precio;
        this.peso = peso;
    }
    
    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public double getPeso() { return peso; }
}