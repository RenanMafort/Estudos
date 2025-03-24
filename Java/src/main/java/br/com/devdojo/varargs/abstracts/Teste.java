package br.com.devdojo.varargs.abstracts;

public class Teste {
    public static void main(String[] args) {
        Funcionario f = new Funcionario(200.00);
        Desco f1 = new Deve(300.00) ;

        System.out.println(f);
        System.out.println(f1);
    }
}
