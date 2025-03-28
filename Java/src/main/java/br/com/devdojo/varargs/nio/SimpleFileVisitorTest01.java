package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {


           System.out.println(file.getFileName());

           return FileVisitResult.SKIP_SUBTREE;
    }
}
public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("renansereia/renan");
        Files.walkFileTree(path, new ListJavaFiles());
    }
}
