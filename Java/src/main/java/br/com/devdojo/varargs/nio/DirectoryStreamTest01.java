package br.com.devdojo.varargs.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        Path path = Paths.get("renansereia/renan/sereia/mafort/");
        try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){
//            for (Path path1 : directoryStream){
//                boolean b = path1.getFileName().toString().startsWith("renan - Copia (4)");
//                System.out.println(b);
//                if (b){
//                    Files.deleteIfExists(path1);
//                }
//
//                System.out.println(path1.getFileName());
//            }

            while (directoryStream.iterator().hasNext()){


            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
