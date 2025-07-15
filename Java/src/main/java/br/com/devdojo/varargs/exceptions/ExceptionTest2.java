package br.com.devdojo.varargs.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class ExceptionTest2 {
    public static void main(String[] args) throws IOException{
            criarNovoArquivo();
    }

    public static void criarNovoArquivo() throws IOException {
        File file = new File("arquivos/renan.txt");
        try {
            boolean criado = file.createNewFile();
            System.out.println("Arquivo criado? = " + criado);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" foi lançadao um erro ao ler o arquivo");

        }
    }
}
