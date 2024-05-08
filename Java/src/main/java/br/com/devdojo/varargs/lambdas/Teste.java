package br.com.devdojo.varargs.lambdas;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

class Exemplo {
    private String nome = "Renan Mafort Sereia";

    public String getNome(){
        return this.nome;
    }
}

public class Teste {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Exemplo ex1 = new Exemplo();
        Field nome = ex1.getClass().getDeclaredField("nome");
        nome.setAccessible(true);
        AccessibleObject.setAccessible(new AccessibleObject[]{nome},true);

        String nome1 = ex1.getNome();
        System.out.println(nome1);
        nome.set(ex1, "Sereia");

        System.out.println(ex1.getNome());
    }
}
