package br.com.springboot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyFileNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -5113509279839799959L;

    public MyFileNotFoundException(String message) {
        super(message);
    }
    public MyFileNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
}
