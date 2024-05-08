package br.com.devdojo.varargs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        Path path = Paths.get(".");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){



            for (Path path1 : directoryStream){

            }

            while (directoryStream.iterator().hasNext()){
                long l = directoryStream.iterator().next().toFile().lastModified();

            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
