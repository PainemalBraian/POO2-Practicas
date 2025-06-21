package tp7Strategy.ejercicio3;

public class Main {
    public static void main(String[] args) {
        var strategy = new CalculadorBase();

        var p1 = new Producto(new Libro(130), strategy);
        var p2 = new Producto(new Medicina(130), strategy);
        var p3 = new Producto(new Alimento(130), strategy);
        var p4 = new Producto(new Electronica(130), strategy);

        System.out.println("Libro: "+p1.precioFinal());
        System.out.println("Medicina: "+p2.precioFinal());
        System.out.println("Alimento: "+p3.precioFinal());
        System.out.println("Otro: "+p4.precioFinal());
    }
}
