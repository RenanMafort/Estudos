package io.github.renansereia.quarkussocial.rest.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {

    private String message;
    private Collection<FieldError> errors;

    public static <T> ResponseError createFromValidation(Set<ConstraintViolation<T>> violations){
        List<FieldError> list = violations.stream().map(
                cv -> new FieldError(cv.getPropertyPath().toString(), cv.getMessage()))
                .toList();

        String message = "Validation Error";
        return new ResponseError(message,list);
    }

    public Response withStatusCode(int code){
        return Response.status(code).entity(this).build();
    }


}
