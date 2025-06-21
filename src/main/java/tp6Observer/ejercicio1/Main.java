package tp6Observer.ejercicio1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
//        var consola = new ConsolaObs();
//        var subject = new Medidor(new RandomWeatherChannelService());
//
//        subject.addObserver(consola);
//        System.out.println("Consola: " + subject.leerTemperatura() );
//----------------------------------------------------------------------------
        ClimaOnline servicio = new WeatherChannelService();
        Medidor medidor = new Medidor(servicio);

        medidor.addObserver(new ConsolaObs());
        System.out.println("Temperatura actual: " + medidor.leerTemperatura());

    }
}
