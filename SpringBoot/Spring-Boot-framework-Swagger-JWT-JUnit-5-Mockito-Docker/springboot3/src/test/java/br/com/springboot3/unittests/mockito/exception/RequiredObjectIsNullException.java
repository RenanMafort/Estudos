package br.com.springboot3.unittests.mockito.exception;

import java.io.Serial;

public class RequiredObjectIsNullException extends Exception{
    @Serial
    private static final long serialVersionUID = -4591430845427525777L;

    public RequiredObjectIsNullException(String message) {
        super(message);
    }
}
