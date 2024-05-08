package br.com.springboot3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
import java.io.Serializable;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidJwtAuthenticationException extends AuthenticationException implements Serializable {

    @Serial
    private static final long serialVersionUID = 8116116730099890074L;

    public InvalidJwtAuthenticationException(String explanation) {
        super(explanation);
    }
}
