package br.com.devdojo.varargs.exceptions;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class RuntimeExceptionTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            divisao(1,0);
        }catch (RuntimeException e ){
            e.printStackTrace(new PrintWriter("arquivos/teste.txt"));
        }
        System.out.println("Finalizado");
    }

    private static int divisao(int a, int b){
        if (b==0){
            throw new IllegalArgumentException("Argumento inválido");
        }
        return  a/b;
    }
}
