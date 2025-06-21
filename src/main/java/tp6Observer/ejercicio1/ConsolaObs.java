package tp6Observer.ejercicio1;

public class ConsolaObs implements Observer{
    @Override
    public void update(String data) {
        if (Integer.parseInt(data.substring(0, 1).trim() ) < 12) {
            System.out.println("Hace frío, se encenderá la caldera. " + data);}
        else {
            System.out.println("Hace calor, se encenderá el aire acondicionado. " + data);
        }
    }
}
