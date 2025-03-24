package br.com.devdojo.varargs.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorioProjeto = "home/renan/dev";
        String arquivoTxt = "../../arquivo.txt";
        Path path = Paths.get(diretorioProjeto, arquivoTxt);
        System.out.println(path);
        System.out.println(path.normalize());

        Path path2 = Paths.get("/home/./renan/./dev/");
        Path path3 = Paths.get("/home/./renan/.  renan / / / / / //dev/");
        System.out.println(path2);
        System.out.println(path2.normalize());
        System.out.println(path3);
        System.out.println(path3.normalize());
    }
}
