package tp6Observer.ejercicio1;

public class Main {
    public static void main(String[] args) {
        var consola = new ConsolaObs();
        var subjectConcreto = new Medidor(new WeatherChannelService());

        subjectConcreto.addObserver(consola);
        System.out.println("Sout de Main: " + subjectConcreto.leerTemperatura() );
    }
}
