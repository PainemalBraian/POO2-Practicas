package tp7Strategy.ejercicio3;

public class ejemplo {
    enum TipoProducto {
        LIBRO,
        ALIMENTO,
        MEDICINA,
        OTRO
    }

    public class Producto {
        public TipoProducto tipo;
        public double precio;

        public Producto(TipoProducto tipo, double precio) {
            this.tipo = tipo;
            this.precio = precio;
        }

        public double precioFinal() {
            double impuestos = 0;
            double descuentos = 0;
            boolean envioGratis = false;

            if (tipo == TipoProducto.LIBRO) {
                impuestos = 0.1;
                descuentos = 0.1;
                if (precio > 100) {
                    envioGratis = true;
                }
            } else if (tipo == TipoProducto.ALIMENTO) {
                impuestos = 0.05;
                if (precio > 100) {
                    descuentos = 0.15;
                }
                if (precio > 200) {
                    envioGratis = true;
                }
            } else if (tipo == TipoProducto.MEDICINA) {
                impuestos = 0;
                if (precio > 50) {
                    descuentos = 0.1;
                }
                if (precio > 100) {
                    envioGratis = true;
                }
            } else {
                impuestos = 0.15;
                if (precio > 50) {
                    descuentos = 0.05;
                }
                if (precio > 200) {
                    envioGratis = true;
                }
            }

            double total = precio * (1 + impuestos) * (1 - descuentos);
            if (envioGratis) {
                total -= 10;
            }
            return total;
        }
    }

    public class Main {
        public void main(String[] args) {
            var p1 = new Producto(TipoProducto.LIBRO, 30);
            var p2 = new Producto(TipoProducto.MEDICINA, 330);
            var p3 = new Producto(TipoProducto.ALIMENTO, 130);
            var p4 = new Producto(TipoProducto.OTRO, 130);

            System.out.println(p1.precioFinal());
            System.out.println(p2.precioFinal());
            System.out.println(p3.precioFinal());
            System.out.println(p4.precioFinal());
        }
    }
}
