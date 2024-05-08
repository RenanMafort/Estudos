package br.com.devdojo.varargs.exceptions.dominio;

import java.io.Closeable;

public class Leitor3 implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Renan Teste ...");
    }
}
