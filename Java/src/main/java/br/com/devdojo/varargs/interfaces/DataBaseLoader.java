package br.com.devdojo.varargs.interfaces;

public class DataBaseLoader implements DataLoader,DataRemover{
    @Override
    public void load() {
        System.out.println("Carregando");
    }

    @Override
    public void checkPermission() {
        System.out.println("VITOR PINTO");
    }
    @Override
    public void remove() {
        System.out.println("Removendo DataBase");
    }
}
