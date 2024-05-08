package br.com.devdojo.varargs.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/renan");
        Path classe = Paths.get("/home/renan/devteste/hello-word.java");
        Path pathToclass = dir.relativize(classe);
        System.out.println(pathToclass);

        Path absoluteOne = Paths.get("/home/renan");
        Path absoluteTwo = Paths.get("/user/local");
        Path absoluteThree = Paths.get("/home/renan/devteste/hello-word.java");
        Path relativeOne = Paths.get("temp");
        Path relativeTwo = Paths.get("temp/temp.35333");

        System.out.println("1 " + absoluteOne.relativize(absoluteThree));
        System.out.println("2 " + absoluteThree.relativize(absoluteOne));
        System.out.println("3 " + absoluteOne.relativize(absoluteTwo));
        System.out.println("4 " + relativeOne.relativize(relativeTwo));
        System.out.println("5 " + absoluteOne.relativize(relativeOne));
    }
}
