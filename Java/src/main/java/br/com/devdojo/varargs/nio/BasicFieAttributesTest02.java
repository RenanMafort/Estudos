package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;

public class BasicFieAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta_renamed/new.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        FileTime creationTime = basicFileAttributes.creationTime();

        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();

        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println(creationTime);

        System.out.println(lastModifiedTime);

        System.out.println(lastAccessTime);

        Class<BasicFileAttributeView> basicFileAttributeViewClass = BasicFileAttributeView.class;

        System.out.println("getName - " + basicFileAttributeViewClass.getName());

        System.out.println("getAnnotations - " +basicFileAttributeViewClass.getAnnotations().toString());

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        FileTime millis = FileTime.fromMillis(System.currentTimeMillis());

        fileAttributeView.setTimes(lastModifiedTime, millis, creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();

        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();

        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        System.out.println(creationTime);

        System.out.println(lastModifiedTime);

        System.out.println(lastAccessTime);


    }
}
