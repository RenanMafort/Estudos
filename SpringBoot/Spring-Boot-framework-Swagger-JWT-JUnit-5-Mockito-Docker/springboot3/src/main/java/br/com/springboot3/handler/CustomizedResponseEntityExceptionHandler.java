package br.com.springboot3.handler;

import br.com.springboot3.exception.ExceptionResponse;
import br.com.springboot3.exception.InvalidJwtAuthenticationException;
import br.com.springboot3.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) throws SQLException {
        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundtException(Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidJwtAuthenticationException.class)
    public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex, WebRequest request) {

        ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(response, HttpStatus.FORBIDDEN);
    }
}
