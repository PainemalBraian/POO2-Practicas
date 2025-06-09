package tp5TemplateMethodAndComposite.ejercicio3Composite;

public class TestSeguros {
    public static void main(String[] args) {
        Seguro auto = new SeguroAuto(10000);
        Seguro vida = new SeguroVida(8000);
        Seguro hogar = new SeguroHogar(6000);

        SegurosComposite paquete1 = new SegurosComposite();
        paquete1.agregarSeguro(auto);
//        paquete1.agregarSeguro(vida);

        SegurosComposite paquete2 = new SegurosComposite();
        paquete2.agregarSeguro(hogar);
        paquete2.agregarSeguro(paquete1);  // Paquete dentro de otro

        System.out.println("Costo paquete1 (Auto + Vida): " + paquete1.costo());  // Esperado: (10000+8000)*0.95^2
        System.out.println("Costo paquete2 (Hogar + paquete1): " + paquete2.costo());  // Acumulativo
    }
}
