package br.com.devdojo.varargs.interfaces;

public class Main {
    public static void main(String[] args) {
        DataBaseLoader dataBaseLoader = new DataBaseLoader();
        FileLoader fileLoader = new FileLoader();
        dataBaseLoader.load();
        dataBaseLoader.checkPermission();
        fileLoader.load();
        fileLoader.checkPermission();
    }
}
