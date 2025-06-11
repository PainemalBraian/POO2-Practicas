package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class ComboBuilder {
    private Combo combo;

    public ComboBuilder() {
        this.combo = new ComboBase() {
        };
    }

    public ComboBuilder basico() {
        this.combo = new ComboBasico(this.combo);
        return this;
    }
    public ComboBuilder familiar() {
        this.combo = new ComboFamiliar(this.combo);
        return this;
    }
    public ComboBuilder especial() {
        this.combo = new ComboEspecial(this.combo);
        return this;
    }
    public ComboBuilder porcionExtra(Porcion porcion) {
        this.combo = new ComboConPorcionExtra(this.combo, porcion);
        return this;
    }
    public Combo build(){
        return this.combo;
    }
}
