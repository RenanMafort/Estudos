package br.com.devdojo.varargs.wrappers;

public class StringBuilderTest {
    public static void main(String[] args) {
        Boolean b = false;
        String nome = "Renan";
        nome = nome.concat(" Mafort");
        System.out.println(nome);

        StringBuilder sb = new StringBuilder("Renan");
        sb.append(" Sereia");
        sb.append(" Teste");
        sb.reverse();
        sb.reverse();
        System.out.println(sb.substring(0,3));
        System.out.println(sb);
    }
}
