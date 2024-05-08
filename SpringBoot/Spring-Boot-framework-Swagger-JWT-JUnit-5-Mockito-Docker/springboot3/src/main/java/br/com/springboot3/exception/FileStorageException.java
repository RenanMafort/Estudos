package br.com.springboot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FileStorageException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -5113509279839799959L;

    public FileStorageException(String message) {
        super(message);
    }
    public FileStorageException(String message,Throwable cause) {
        super(message,cause);
    }
}
