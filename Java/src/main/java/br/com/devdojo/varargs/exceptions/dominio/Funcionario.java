package br.com.devdojo.varargs.exceptions.dominio;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.LoginInvalidoException;

import java.io.FileNotFoundException;

public class Funcionario extends Pessoa{
    @Override
    public void salvar() throws LoginInvalidoException, FileNotFoundException {
        System.out.println("Salvando Funcionario");
    }
}
