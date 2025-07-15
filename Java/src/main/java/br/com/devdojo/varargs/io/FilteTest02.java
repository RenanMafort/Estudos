package br.com.devdojo.varargs.io;

import java.io.File;
import java.io.IOException;

public class FilteTest02 {
    public static void main(String[] args) throws IOException {
//        File fileDiretorio = new File("pasta");
//        boolean isDiretorio = fileDiretorio.mkdir();
//        System.out.println(isDiretorio);
//
//        File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt");
//        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
//        System.out.println(isFileCreated);
//
//        File fileRenamed = new File(fileDiretorio,"arquivo_renomeado2.txt");
//        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
//        System.out.println(isRenamed);
//
//        File diretorioRenamed = new File("pasta_renan_renomeado");
//        boolean isDiretorioRenomeado = fileDiretorio.renameTo(diretorioRenamed);
//        System.out.println(isDiretorioRenomeado);
//
//        boolean isRenamedRenan = diretorioRenamed.renameTo(new File("pasta_renan_renomeado2222222000000"));
//        System.out.println(isRenamedRenan);

        File file = new File("pasta_renan_renomeado2222222000000");
        boolean deboraCamila = file.renameTo(new File("debora_camila"));
        System.out.println(deboraCamila);


    }
}
