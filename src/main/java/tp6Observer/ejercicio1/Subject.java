package tp6Observer.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observadores = new ArrayList<>();


    void addObserver(Observer ob){
        observadores.add(ob);
    }

    void notify(String data){
        for (Observer ob : observadores){
            ob.update(data);
        }
    }

}
