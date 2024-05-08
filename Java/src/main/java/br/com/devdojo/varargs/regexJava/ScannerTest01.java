package br.com.devdojo.varargs.regexJava;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Levi, Eren, Miasa, true, 200";
        String[] nomes = texto.split(",");
        for (String nome: nomes){
            System.out.println(nome.trim());
        }
    }
}
