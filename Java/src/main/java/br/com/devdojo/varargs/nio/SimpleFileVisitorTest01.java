package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFiles extends SimpleFileVisitor<Path> {

    protected ListJavaFiles() {
        super();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println(dir.getFileSystem());
        System.out.println(dir.getFileName());

        return super.preVisitDirectory(dir, attrs);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println(file.getFileSystem());
        System.out.println(file.getFileName());
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println(file.getFileSystem());
        System.out.println(file.getFileName());
        return super.visitFileFailed(file, exc);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println(dir.getFileSystem());
        System.out.println(dir.getFileName());
        return super.postVisitDirectory(dir, exc);
    }
}
public class SimpleFileVisitorTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("renansereia");
        Files.walkFileTree(path, new ListJavaFiles());
    }
}
