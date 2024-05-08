package br.com.devdojo.varargs.errors;

import java.io.Serializable;
import java.util.Random;

public class StackOverFlow implements Serializable {


    public static void recursividade(){
        recursividade();
    }

    public static void testandoSerialVersionUID(){
        Random random = new Random();
        random.doubles();
    }

    public static void main(String[] args) {
        recursividade();
    }
}
