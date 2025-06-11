package tp5xAdapterAndDecorator.ejercicio1Adapter;

public class Main {
    public static void main(String[] args) {
        MotorElectrico motorElectrico = new MotorElectrico();

        MotorAdaptable motorAdaptable = new MotorAdaptable(motorElectrico);

        Motor motorEconomico = new MotorEconomico();
        Motor motorComun = new MotorComun();

        motorEconomico.secuencia();
        motorComun.secuencia();
        motorAdaptable.secuencia();
    }
}
