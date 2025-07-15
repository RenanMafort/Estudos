package br.com.devdojo.varargs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutPutStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/");
        zip(arquivoZip,arquivosParaZipar);
    }

    private static void zip(Path arquivoZip, Path arquivosParaZipar){
        zipOutputStream(arquivoZip, arquivosParaZipar);
    }

    static void zipOutputStream(Path arquivoZip, Path arquivosParaZipar) {
        try(ZipOutputStream zipOutputStream =new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)) {

            for (Path file: directoryStream){
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());
                zipOutputStream.putNextEntry(zipEntry);
                Files.copy(file,zipOutputStream);
                zipOutputStream.closeEntry();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
