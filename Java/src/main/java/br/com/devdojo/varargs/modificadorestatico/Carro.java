package br.com.devdojo.varargs.modificadorestatico;

public class Carro {
    private String nome;
    public static final String marca = "BMW";

    public Carro(String nome) {
        this.nome = nome;
        System.out.println(this.marca);
    }

    public static void imprimire(){

//        this.marca;
    }
}
