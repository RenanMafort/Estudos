package br.com.devdojo.varargs.exceptions.dominio;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.LoginInvalidoException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Pessoa {
    public void salvar() throws LoginInvalidoException, IOException {
        System.out.println("Salvando PESSOA");
    }
}
