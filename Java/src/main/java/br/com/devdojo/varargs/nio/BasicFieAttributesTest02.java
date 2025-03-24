package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class BasicFieAttributesTest02 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:\\Meus_Itens\\java-dev-dojo\\renan\\subpasta\\subsubpasta\\arquivo_renomeado2.txt");
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        FileTime creationTime = basicFileAttributes.creationTime();

        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();

        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println(creationTime);

        System.out.println(lastModifiedTime);

        System.out.println(lastAccessTime);
//
        Class<BasicFileAttributeView> basicFileAttributeViewClass = BasicFileAttributeView.class;

        System.out.println("getName - " + basicFileAttributeViewClass.getName());

        System.out.println("getAnnotations - " + Arrays.toString(basicFileAttributeViewClass.getAnnotations()));

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        FileTime millis = FileTime.fromMillis(System.currentTimeMillis());
        System.out.println(millis.toMillis());
        System.out.println(FileTime.fromMillis(new Date().getTime()).toMillis());

        fileAttributeView.setTimes(lastModifiedTime, millis, creationTime);

        creationTime = fileAttributeView.readAttributes().creationTime();

        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();

        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();

        System.out.println(creationTime);

        System.out.println(lastModifiedTime);

        System.out.println(lastAccessTime);


        // Ou podemos usar isso para atualizar as datas do arquivo

        Files.setAttribute(path,"basic:lastModifiedTime",FileTime.fromMillis(Instant.now().toEpochMilli()));
        Files.setAttribute(path,"basic:lastAccessTime",FileTime.fromMillis(Instant.now().toEpochMilli()));
        Files.setAttribute(path,"basic:creationTime",FileTime.fromMillis(Instant.now().toEpochMilli()));


    }
}
