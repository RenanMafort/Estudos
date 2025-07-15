package br.com.devdojo.varargs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
//        BasicFileAttributes - Windows
//        DosFileAttributes - DOS ou Windows
//        PosixFileAttributes - POSIX - unix


        LocalDateTime date = LocalDateTime.now().minusDays(10);
        System.out.println(date);
        File file = new File("pasta_renamed/novo.txt");
        boolean isCreated = file.createNewFile();
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        Path path = Paths.get("teste");
        boolean b = Files.notExists(path);
        if (b){
            Files.createFile(path);
            Files.createDirectory(path);
        }

        //New method
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        System.out.println(fileTime);
        Path path1 = Files.setLastModifiedTime(path, fileTime);
        System.out.println(path1);
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isExecutable(path));

    }
}
