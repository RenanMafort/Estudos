package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.*;

public class PathTest02 {
    public static void main(String[] args) throws IOException{
        Path pastaPath = Paths.get("arquivo_renomeado2.txt");
            if (Files.notExists(pastaPath)){
                Path pastaDirectory = Files.createDirectory(pastaPath);
            }
            Path subPastaPath = Paths.get("renan/subpasta/subsubpasta");
            Files.createDirectories(subPastaPath);
        Path path = Paths.get(subPastaPath.toString(), "file.txt");
        if (Files.notExists(path)){
            Files.createFile(path);
        }


        Path source = path;
        Path target = Paths.get(path.getParent().toString(),"arquivo_renomeado2.txt");
        Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);

    }
}
