package tp5xAdapterAndDecorator.ejercicio1Adapter;

public abstract class Motor {

    public Motor() {
    }

    public void secuencia(){
        System.out.println(getClass().getName());
        arrancar();
        acelerar();
        apagar();
        System.out.println();
    }

    public void arrancar(){
        System.out.println("Arrancando");
    }
    public void acelerar(){
        System.out.println("Acelerando");
    }
    public void apagar(){
        System.out.println("Apagando");
    }
}
