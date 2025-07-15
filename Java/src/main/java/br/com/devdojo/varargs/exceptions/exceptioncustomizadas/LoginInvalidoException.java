package br.com.devdojo.varargs.exceptions.exceptioncustomizadas;

import java.io.Serial;

public class LoginInvalidoException extends Exception{
    @Serial
    private static final long serialVersionUID = 8947623680326347354L;

    public LoginInvalidoException() {
        super("Login inválido");
    }

    public LoginInvalidoException(String message) {
        super(message);
    }
}
