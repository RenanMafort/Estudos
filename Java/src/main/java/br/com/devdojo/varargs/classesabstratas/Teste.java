package br.com.devdojo.varargs.classesabstratas;


public class Teste {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Nami",5000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Renan",12000);
        System.out.println(gerente);
        System.out.println(desenvolvedor);

    }
}
