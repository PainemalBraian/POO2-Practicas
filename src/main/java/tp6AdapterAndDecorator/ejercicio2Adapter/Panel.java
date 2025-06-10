package tp6AdapterAndDecorator.ejercicio2Adapter;

public interface Panel {

    void circulo(Coordenada coor, int radio);

    void linea(Coordenada coor, int longitud);

    void texto(Coordenada coor, String texto);

}
