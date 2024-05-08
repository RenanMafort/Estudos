package br.com.devdojo.varargs.interfaces;

public interface DataLoader  {
    public static final int MAX_DATA_SIZE = 10;
    void load();
    public default void checkPermission(){
        System.out.println("Fazendo checkPermission");
    }

    public static void retrieveMaxDataSize(){
        System.out.println("Dentro do retrieveMaxDataSize");
    }
}
