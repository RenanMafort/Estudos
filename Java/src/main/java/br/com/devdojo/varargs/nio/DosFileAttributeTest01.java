package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeTest01 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("arquivos/teste.txt");
        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());

        Files.setAttribute(path,"dos:hidden",false);

        if (!Files.exists(path)){
            Files.createFile(path);
            System.out.println(dosFileAttributes.isHidden());
            System.out.println(dosFileAttributes.isReadOnly());
        }
        Files.setAttribute(path,"dos:hidden",true);
//        Files.setAttribute(path,"dos:readonly",true);
//
//        Files.setAttribute(path,"dos:hidden",false);
//        Files.setAttribute(path,"dos:readonly",false);
//
        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);
        fileAttributeView.setArchive(true);

    }
}
