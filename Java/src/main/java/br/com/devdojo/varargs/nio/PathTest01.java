package br.com.devdojo.varargs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {

        Path path1 = Path.of("D:\\MEUS_ITENS\\java-dev-dojo","teste.txt");
        Path path2 = Paths.get("D:\\MEUS_ITENS\\java-dev-dojo\\teste.txt");
        Path path3 = Paths.get("D","MEUS_ITENS","java-dev-dojo","teste.txt");
        System.out.println(path1.getFileName().toFile().toPath().toFile().toPath().toFile());
        System.out.println(path2.getFileName());
        System.out.println(path3.getFileName());
    }
}
