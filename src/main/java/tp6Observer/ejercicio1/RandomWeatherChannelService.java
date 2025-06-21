package tp6Observer.ejercicio1;

import java.util.Random;

public class RandomWeatherChannelService implements ClimaOnline {

    @Override
    public String temperatura() {
        int temp = new Random().nextInt(100);
        return temp + " c";
    }
}