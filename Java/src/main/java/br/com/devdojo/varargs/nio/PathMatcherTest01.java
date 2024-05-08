package br.com.devdojo.varargs.nio;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta1/file.bkp");
        Path path2 = Paths.get("pasta/subpasta1/file.txt");
        Path path3 = Paths.get("pasta/subpasta1/file.java");

        matches(path1,"glob:*.bkp");
        matches(path1,"glob:**/*.bkp");// ignore tudo pra trás e traga .bkp
        matches(path1,"glob:**/*.{bkp,txt,java}");// ignore tudo pra trás e traga bkp,txt,java
        matches(path2,"glob:**/*.{bkp,txt,java}");// ignore tudo pra trás e traga bkp,txt,java
        matches(path3,"glob:**/*.{bkp,txt,java}");// ignore tudo pra trás e traga bkp,txt,java

        matches(path1,"glob:**/*.???");//o arquivo tem 3 letras na extensão?
        matches(path2,"glob:**/*.???");//o arquivo tem 3 letras na extensão?
        matches(path3,"glob:**/*.???");//o arquivo tem 3 letras na extensão?
        matches(path3,"glob:**/file.????");//o arquivo tem 4 letras na extensão?
    }
    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + ": " + matcher.matches(path));
    }
}
