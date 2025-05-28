package tp5TemplateMethodAndComposite.ejercicio3Composite;

public interface Seguro {
    void costo();
    void agregarAlPaquete();
    void costoPaquete();


}

//    Se desea desarrollar una aplicación de gestión de seguros que pueda manejar seguros de
//    distinto tipo (hogar, automóvil, vida y médicos) y que permita crear paquetes de seguros que agrupen seguros (y también otros paquetes).
//    El costo de cada paquete está dado por el costo individual de cada seguro, pero aplica un descuento del 5%, acumulativo, por cada seguro incluido en el paquete.
//
//
//    a) Aplicando el patrón Composite, diseñe el diagrama de clases que permita modelar este escenario y que
//    permita calcular el costo de cada seguro y de los paquetes de seguros ofrecidos por la compañía.
//
//    b) Implemente la solución en Java y dos casos de prueba.
