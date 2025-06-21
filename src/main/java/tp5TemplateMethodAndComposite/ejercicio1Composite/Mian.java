package tp5TemplateMethodAndComposite.ejercicio1Composite;

public class Mian {
    public static void main(String[] args) {
        Director director = new Director(100000);
        Gerente gerente = new Gerente(60000);
        MandoMedio mando = new MandoMedio(40000);
        LiderProyecto lider = new LiderProyecto(25000);
        EmpleadoRegular emp1 = new EmpleadoRegular(10000);

        lider.agregarSubordinado(emp1);
        mando.agregarSubordinado(lider);
        gerente.agregarSubordinado(mando);
        director.agregarSubordinado(gerente);

        System.out.println("Salario total de la empresa: " + director.salario());
    }
}

