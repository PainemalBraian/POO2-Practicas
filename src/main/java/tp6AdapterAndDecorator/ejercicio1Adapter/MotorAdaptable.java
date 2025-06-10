package tp6AdapterAndDecorator.ejercicio1Adapter;

public class MotorAdaptable extends Motor{
    MotorElectrico motor;

    public MotorAdaptable(MotorElectrico motor) {
        this.motor = motor;
    }

    @Override
    public void arrancar(){
        motor.conectar();
        motor.activar();
    }

    @Override
    public void acelerar(){
        motor.moverMasRapido();
    }

    @Override
    public void apagar(){
        motor.detener();
        motor.desconectar();
    }

}
