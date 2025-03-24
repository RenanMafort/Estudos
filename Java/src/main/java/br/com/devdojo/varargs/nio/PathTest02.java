package br.com.devdojo.varargs.nio;

import java.io.IOException;
import java.nio.file.*;

public class PathTest02 {
    public static void main(String[] args) throws IOException{
//        Path pastaPath = Paths.get("arquivo_renomeado2.txt");
//            if (Files.notExists(pastaPath)){
//                Path pastaDirectory = Files.createDirectory(pastaPath);
//            }
        Path renansereia = Path.of("renansereia");
//        Files.createDirectory(renansereia);
        Path path = Path.of(renansereia.getFileName().toString(), "renan", "sereia", "mafort","renan.txt");
//        Files.createFile(path);

        Path path1 = Path.of(path.getParent().toString(), "file.txt");
        Files.copy(path,path1.getParent().getParent(),StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);
//        if (Files.exists(renansereia)){
//
//            Files.createDirectories(Path.of(renansereia.getFileName().toString(),"renan","sereia","mafort"));
//        }

//        Files.copy(path,Paths)

//            Path subPastaPath = Paths.get("renan/subpasta/subsubpasta");
//            Files.createDirectories(subPastaPath);
//        Path path = Paths.get(subPastaPath.toString(), "file.txt");
//        if (Files.notExists(path)){
//            Files.createFile(path);
//        }

//
//        Path source = path;
//        Path target = Paths.get(path.getParent().toString(),"arquivo_renomeado2.txt");
//        Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);

    }
}
