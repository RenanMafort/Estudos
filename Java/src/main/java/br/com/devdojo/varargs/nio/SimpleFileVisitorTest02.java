package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListAllFiles extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)  {
           System.out.println(file.getFileName());
           return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("pre visit" + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("post visit" + dir.getFileName());
        return FileVisitResult.CONTINUE;
    }
}
public class SimpleFileVisitorTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta");
        Files.walkFileTree(path, new ListAllFiles());
    }
}
