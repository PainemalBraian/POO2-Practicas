package tp5TemplateMethodAndComposite.ejercicio3Composite;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class gestionSegurosTest {
    @Test
    void testCostoUnicoPaquete() {
        Seguro auto = new SeguroAuto(10000);
        Seguro vida = new SeguroVida(8000);

        SegurosComposite paquete = new SegurosComposite();
        paquete.agregarSeguro(auto); // 10000
        paquete.agregarSeguro(vida); // 8000
        // 18000 * .90 = 16200

        System.out.println("Costo paquete Unico: " + paquete.costo());
        assertEquals(16200, paquete.costo());
    }

    @Test
    void testCostoPaqueteAgregado() {
        Seguro auto = new SeguroAuto(10000);
        Seguro hogar = new SeguroHogar(6000);

        SegurosComposite paquete = new SegurosComposite();
        paquete.agregarSeguro(auto); // 10000
        paquete.agregarSeguro(auto); // 10000
        // 20.000 * .90 = 18.000
        SegurosComposite paqueteFinal = new SegurosComposite();
        paqueteFinal.agregarSeguro(hogar);      // 6000
        paqueteFinal.agregarSeguro(paquete); // 18000
        // 24000 * .90 = 21600

        System.out.println("Costo paquete Agregado: " + paqueteFinal.costo());
        assertEquals(21600, paqueteFinal.costo());
    }
}
