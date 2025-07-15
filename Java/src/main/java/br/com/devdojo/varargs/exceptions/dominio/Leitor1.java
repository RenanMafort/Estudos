package br.com.devdojo.varargs.exceptions.dominio;

import java.io.Closeable;
import java.io.IOException;

public class Leitor1 implements Closeable {
    @Override
    public void close() throws IOException {
        System.out.println("Fechando leitor 1");
    }

    public void teste() throws Exception{
        System.out.println("Teste throws exception");
    }
}
