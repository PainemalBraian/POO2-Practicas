package tp6Observer.ejercicio1;

public class Medidor extends Subject {
    private String temperatura;
    private ClimaOnline clima;

    public Medidor(ClimaOnline clima) {
        this.clima = clima;
    }

    public String leerTemperatura() {
        // leo la temperatura del servicio web
        this.temperatura = this.clima.temperatura();
        notify(this.temperatura);
        return this.temperatura;
    }
}


