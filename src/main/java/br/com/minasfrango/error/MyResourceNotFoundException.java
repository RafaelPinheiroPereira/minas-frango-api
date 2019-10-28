package br.com.minasfrango.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) // Status - 404
public class MyResourceNotFoundException extends RuntimeException {

    public MyResourceNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
