package br.com.devdojo.varargs.classesabstratas;

public class Teste {
    public static void main(String[] args) {
        Desenvolvedor dev = new Desenvolvedor("Renan",22.00);
        Funcionario f = new Desenvolvedor("Renan",22.00);
        Gerente f2 = new Gerente("Renan",22.00);
        System.out.println(dev);
        System.out.println(f);
        System.out.println(f2);
    }
}
