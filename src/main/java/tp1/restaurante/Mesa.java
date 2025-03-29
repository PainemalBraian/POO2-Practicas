package tp1.restaurante;

import java.util.ArrayList;

public class Mesa {
    static String CAPACIDAD_COMENSALES_COMPLETA = "Capacidad de comensales completa";
    static int idMesa = 0;
    private int id;
    private int capacidad;
    private boolean confirmarPedido = false;
    private ArrayList<Producto> menu;
    private ArrayList<Comensal> comensales;
    private ArrayList<Producto> pedido;
    private ArrayList<Integer> cantidades;

    public Mesa(int capacidad) {
        this.id = idMesa++;
        this.capacidad = capacidad;
        this.menu = new ArrayList<>();
        this.comensales = new ArrayList<>();
        this.pedido = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }


    public void sentarComensal(Comensal comensal) {
        if (estaDentroCapacidad()) this.comensales.add(comensal);
        else throw new RuntimeException(CAPACIDAD_COMENSALES_COMPLETA);
    }

    private boolean estaDentroCapacidad() {
        return comensales.size() <= capacidad;
    }

    public boolean seConfirmoPedido() {
        return confirmarPedido;
    }

    public void addProducto(Producto producto) {
        this.menu.add(producto);
    }

    public void addPedido(Producto producto, int cantidad) {
        if (producto.disminuirStock(cantidad)) for (int i = 0; i <= cantidad; i++) {
            pedido.add(producto);
            cantidades.add(cantidad);
        }
    }

    public String mostrarMenu() {
        StringBuffer menuDisponible = new StringBuffer();
        for (int i = 0; i < menu.size(); i++) {
            menuDisponible.append("\n" + "\n" + menu.get(i).verProducto());
        }
        return menuDisponible.toString();
    }

    public void realizarPedido() {
        if (pedido.size() != cantidades.size()) {
            throw new RuntimeException("El número de productos no coincide con las cantidades.");
        }
        confirmarPedido = true;
    }

    public void pagarPedido(TarjetaCredito tarjeta, int porcentajePropina) {
        if (!confirmarPedido) {
            throw new RuntimeException("El pedido debe ser confirmado antes de realizar el pago.");
        }

        double totalBebidas = 0;
        double totalPlatos = 0;

        for (int i = 0; i < pedido.size(); i++) {
            Producto producto = pedido.get(i);
            if (producto.esTipo("BEBIDA")) {
                totalBebidas += producto.getCosto() * cantidades.get(i);
            } else if (producto.esTipo("PLATO")) {
                totalPlatos += producto.getCosto() * cantidades.get(i);
            }
        }

        double descuento = 0;

        if (tarjeta.esTipo("Visa")) {
            descuento = totalBebidas * 0.03; // 3% descuento en bebidas
        } else if (tarjeta.esTipo("Mastercard")) {
            descuento = totalPlatos * 0.02; // 2% descuento en platos
        } else if (tarjeta.esTipo("Comarca Plus")) {
            descuento = (totalBebidas + totalPlatos) * 0.02; // 2% descuento total
        }

        double totalConDescuento = (totalBebidas + totalPlatos) - descuento;
        double propina = totalConDescuento * (porcentajePropina / 100.0);

        double totalFinal = totalConDescuento + propina;

        String detallePago = generarDetallePago(id, totalBebidas, totalPlatos, descuento, porcentajePropina, propina, totalFinal);
        System.out.println(detallePago);

    }

    private String generarDetallePago(int id, double totalBebidas, double totalPlatos, double descuento, int porcentajePropina, double propina, double totalFinal) {
        String detalle = "Pago realizado para la mesa " + id + "\n" +
                "Total antes del descuento: $" + String.format("%.2f", totalBebidas + totalPlatos) + "\n" +
                "Descuento aplicado: $" + String.format("%.2f", descuento) + "\n" +
                "Propina (" + porcentajePropina + "%): $" + String.format("%.2f", propina) + "\n" +
                "Total final: $" + String.format("%.2f", totalFinal);
        return detalle;
    }

}


//    Un restaurante local le solicita el desarrollo de un sistema para calcular el costo consumido por cada mesa.
//    El restaurante posee diez mesas, con diferente capacidad.
//    Los comensales asisten al restaurante y se ubican en las mesas de acuerdo a su preferencia.
//    Es un restaurante particular, no tiene mozos

//    Los comensales una vez ubicados en una mesa, utilizan un dispositivo electrónico donde pueden navegar un menú que contiene bebidas y platos principales con su precio.
//    Los pedidos se arman seleccionando platos y bebidas del menú, más la cantidad para cada caso.
//    Finalizada la elección, se confirma el pedido (una vez confirmado no puede cambiarse).

//    La única forma de pago permitida es con tarjeta de crédito, utilizando el mismo dispositivo para realizar el pedido.
//    Los pagos con tarjeta de crédito Visa tienen un descuento del 3% sobre el costo total de las bebidas.
//    Los pagos con tarjeta de crédito Mastercard tienen un 2% de descuento sobre el costo total de los platos principales.
//    Los pagos con tarjeta de crédito Comarca Plus tienen un descuento del 2% sobre el costo total (bebidas + platos principales).
//    Cualquier otro tipo de tarjeta no posee descuento.

//    Además del costo de la comida, es obligatorio dejar propina, que puede ser: 2%, 3% o 5% del costo total.
