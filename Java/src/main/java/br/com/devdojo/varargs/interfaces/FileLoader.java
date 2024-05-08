package br.com.devdojo.varargs.interfaces;

public class FileLoader implements DataLoader,DataRemover{
    @Override
    public void load() {
        System.out.println("Carregando arquivo");
    }

    @Override
    public void remove() {
        System.out.println("Deletando dados do FileLoader");
    }
}
