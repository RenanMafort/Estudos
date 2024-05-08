package br.com.devdojo.varargs.wrappers;

public class Strings {
    public static void main(String[] args) {
        String nome = "Renan";
        String nome2 = "Renan";
        nome.concat(" Mafort");
        System.out.println(nome);
        System.out.println(nome2);
        String nome3 = new String("Renan");

        System.out.println(nome == nome3.intern());

        String teste = "Renan Mafort Sereia";
        System.out.println(teste.charAt(teste.length()-1));
        System.out.println(teste.substring(3 ));
    }
}
