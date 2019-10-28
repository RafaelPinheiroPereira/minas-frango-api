package br.com.minasfrango.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.minasfrango.error.ErrorResponse;
import br.com.minasfrango.error.MyResourceNotFoundException;

@Component
@ControllerAdvice
public class MyRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyResourceNotFoundException.class)
    public ResponseEntity<?> handlerResourceNotFoundException(MyResourceNotFoundException myResourceNotFoundException) {
        ErrorResponse errorResponse = new ErrorResponse("Resource Not Found", myResourceNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value(),
            myResourceNotFoundException.getClass().getName());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
