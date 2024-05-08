package br.com.devdojo.varargs.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/renan");
        Path arquivo = Paths.get("dev/arquivo.txt");
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        Path absolute = Paths.get("/home/renan");
        Path relativo = Paths.get("dev");
        Path arquivoTxt = Paths.get("file.txt");
        System.out.println("1" +absolute.resolve(resolve));
        System.out.println("2" +absolute.resolve(arquivoTxt));
        System.out.println("3" +relativo.resolve(absolute));
        System.out.println("4" +relativo.resolve(arquivoTxt));
        System.out.println("5" +arquivoTxt.resolve(absolute));
        System.out.println("6" +arquivoTxt.resolve(relativo));

    }
}
