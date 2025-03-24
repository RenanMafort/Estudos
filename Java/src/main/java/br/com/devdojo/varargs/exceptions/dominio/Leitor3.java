package br.com.devdojo.varargs.exceptions.dominio;

import java.io.Closeable;

public class Leitor3 implements AutoCloseable {

    public Leitor3() throws Exception {

    }

    public void teste() throws Exception {
        throw new Exception("Testando");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Renan Teste ...");
    }
}
