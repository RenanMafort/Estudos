package br.com.devdojo.varargs.exceptions.dominio;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.LoginInvalidoException;

import java.io.FileNotFoundException;

public class Pessoa {
    public void salvar() throws LoginInvalidoException, FileNotFoundException{
        System.out.println("Salvando PESSOA");
    }
}
