package br.com.minasfrango.exceptions;

import java.util.List;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ErrorResponse {

    private final String message;
    private final int code;
    private final String status;
    private final String objectName;
    private final List<ObjectError> errors;
}