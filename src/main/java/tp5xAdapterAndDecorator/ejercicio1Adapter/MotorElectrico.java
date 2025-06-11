package tp5xAdapterAndDecorator.ejercicio1Adapter;

public class MotorElectrico {

    public MotorElectrico() {
    }

    public void conectar(){
        System.out.println("Conectando");
    }

    public void activar(){
        System.out.println("Activando");
    }

    public void moverMasRapido(){
        System.out.println("Moviendo Más Rápido");
    }

    public void detener(){
        System.out.println("Deteniendo");
    }

    public void desconectar(){
        System.out.println("Desconectando");
    }
}
