package br.com.devdojo.varargs.polimorfismo.dominio;

public class Computador extends Produto{
    public static final double IMPOSTO_POR_CENTO = 0.2;
    public Computador(String nome, double valor) {
        super(nome, valor);
    }

    @Override
    public double calcularImposto() {
        System.out.println("Imposto do Computador");
        return this.valor  * IMPOSTO_POR_CENTO;
    }


}
