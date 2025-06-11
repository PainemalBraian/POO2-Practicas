package tp5xAdapterAndDecorator.ejercicio4DecoratorAndBuilder;

public class Main {
    public static void main(String[] args) {
//        var combo = new ComboBasico(new ComboBase());
//        combo.descripcion();
//        combo.precio();
//
//        var combo1 = new ComboFamiliar(new ComboBase());
//        combo1.descripcion();
//        combo1.precio();
//
//        var combo2 = new ComboEspecial(new ComboBase());
//        combo2.descripcion();
//        combo2.precio();
//
//        //Extras en ComboBasico
//        combo.addPorcionExtra(new PorcionExtra(Porcion.Queso));
//        combo.descripcion();
//        combo.precio();
//
//        //Extras en ComboEspecial
//        combo2.addPorcionExtra(new PorcionExtra(Porcion.Papas));
//        combo2.addPorcionExtra(new PorcionExtra(Porcion.Carne));
//        combo2.descripcion();
//        combo2.precio();
//
//        //Extras en ComboFamiliar
//        var comboX = new ComboConPorcionExtra(
//                new ComboConPorcionExtra(
//                        new ComboFamiliar(new ComboBase()), Porcion.Tomate), Porcion.Queso);
//        comboX.descripcion();
//        comboX.precio();

        //Uso del builder
        var comboBuild = new ComboBuilder().especial().porcionExtra(Porcion.Papas)
                .build();

        comboBuild.descripcion();
        comboBuild.precio();
    }
}
