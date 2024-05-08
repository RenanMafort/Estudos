package br.com.devdojo.varargs.junit.dominio;

import java.util.Objects;

public record Manga<T>(String name, int episodes) {

    public void Manga(String name){
        Objects.requireNonNull(name);
    }

}
