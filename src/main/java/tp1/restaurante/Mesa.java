package tp1.restaurante;

import java.util.ArrayList;

public class Mesa {
    static String CAPACIDAD_COMENSALES_COMPLETA="Capacidad de comensales completa";
    static int idMesa=0;
    private int id;
    private int capacidad;
    private ArrayList<Producto> menu;
    private ArrayList<Comensal> comensales;
    private ArrayList<Producto> pedido;

    public void sentarComensal(Comensal comensal) {
        if (estaDentroCapacidad())
            this.comensales.add(comensal);
        else throw new RuntimeException(CAPACIDAD_COMENSALES_COMPLETA);
    }

    private boolean estaDentroCapacidad(){
        return comensales.size() <= capacidad;
    }

    public void addProducto(Producto producto){
        this.menu.add(producto);
    }

    public void realizarPedido(Producto producto, int cantidad){
        if ( producto.disminuirStock(cantidad) )
            for(int i=0;i<=cantidad;i++){
                pedido.add(producto);}
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


//    Luego de implementar escriba los siguientes casos de test:
//    1.Cálculo de costo con tarjeta Visa.
//    2. Cálculo de costo con tarjeta Mastercard.
//    3. Cálculo de costo con tarjeta Comarca Plus.
//    4. Cálculo de costo con tarjeta Viedma.
//    Lograr alta cobertura (mayor a 90%).
//    Verifique si quedan funcionalidades sin testear.