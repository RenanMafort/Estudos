package br.com.devdojo.varargs.exceptions.dominio;

import br.com.devdojo.varargs.exceptions.exceptioncustomizadas.LoginInvalidoException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class SobrescritaComExceptionTest {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();
        try {
            pessoa.salvar();
        } catch (LoginInvalidoException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
