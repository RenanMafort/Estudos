package br.com.devdojo.varargs.exceptions.dominio;

import java.io.Closeable;
import java.io.IOException;

public class Leitor2 implements AutoCloseable {
    @Override
    public void close() throws IOException {
        System.out.println("Fechando leitor 2");
    }
}
