package tp5TemplateMethodAndComposite.ejercicio5TemplateMethod;

public abstract class Remera {
    double precioUnitario;

    public Remera(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    final double calcularPrecio(){
        double precio = this.precioUnitario;
        double precioTotal = (precio * calcularVariante());
        System.out.println(this.getClass().getName() +" | Precio: "+precioTotal);
        return precioTotal;
    }

    abstract double calcularVariante();
}
