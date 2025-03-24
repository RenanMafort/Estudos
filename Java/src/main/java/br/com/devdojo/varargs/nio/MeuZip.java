package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class MeuZip {

    public static void main(String[] args) {
        Path sourceZip = Path.of("meuszip/files.zip");
        Path path = Path.of("pasta");
        zip(sourceZip,path);
    }

    public static void zip(Path sourceZip, Path filesZip){

        try (ZipOutputStream zip = new ZipOutputStream(Files.newOutputStream(sourceZip));
             DirectoryStream<Path> stream = Files.newDirectoryStream(filesZip)){
            for (Path file: stream){
                ZipEntry zipando = new ZipEntry(file.getFileName().toString());
                zip.putNextEntry(zipando);
                Files.copy(file,zip);
                zip.closeEntry();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
