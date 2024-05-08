package br.com.devdojo.varargs.polimorfismo.dominio;

public class Tomate extends Produto {
    public static final double IMPOSTO_POR_CENTO = 0.06;
    public Tomate(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Calculando o imposto do tomate");
        return this.valor * IMPOSTO_POR_CENTO;
    }
}
