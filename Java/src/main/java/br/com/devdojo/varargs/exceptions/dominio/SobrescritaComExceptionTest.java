package br.com.devdojo.varargs.exceptions.dominio;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.LoginInvalidoException;

import java.io.FileNotFoundException;

public class SobrescritaComExceptionTest {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();
        try {
            funcionario.salvar();
        } catch (LoginInvalidoException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
