package br.com.devdojo.varargs.exceptions;

import java.io.File;
import java.io.IOException;

public class ExceptionTest1 {
    public static void main(String[] args) {
        criarNovoArquivo();
    }

    private static void criarNovoArquivo()  {
        try {
            File file = new File("arquivsdao\\teste2.txt");
            boolean criado = file.createNewFile();

            System.out.println("Arquivo criado? = " + criado);
            System.out.println(file.exists());
        }catch (IOException e){

            System.out.println("MESSAGE = ");
        }
    }
}
