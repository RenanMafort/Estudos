package br.com.devdojo.varargs.regexJava;

import java.util.Scanner;

public class ScannerTest02 {
    public static void main(String[] args) {
        String texto = "Levi, Eren,Miasa, true, 2200";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");
        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                int i = scanner.nextInt();
                System.out.println("Scanner = " +i);
            } else if (scanner.skip(" ").hasNextBoolean()) {
                boolean b = scanner.nextBoolean();
                System.out.println("Boolean = " + b);
            }else {
                System.out.println(scanner.next());
            }

        }
    }
}
