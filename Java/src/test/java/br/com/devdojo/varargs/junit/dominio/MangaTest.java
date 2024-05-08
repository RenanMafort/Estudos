package br.com.devdojo.varargs.junit.dominio;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MangaTest {
    private Manga manga1;
    private Manga manga2;
    @BeforeEach
    public void setUp(){
        manga1 = new Manga("Teste Manga",24);
        manga2 = new Manga("Teste Manga",24);
    }

    @Test
    public void accessors_ReturnData_WhenInitialized(){
        Assertions.assertEquals("Teste Manga",manga1.name());
        Assertions.assertEquals(24,manga1.episodes());
    }

    @Test
    public void equals_RetunrTrue_WhenObjectsAreTheSame(){
        Assertions.assertEquals(manga1.hashCode(),manga2.hashCode());
    }

}