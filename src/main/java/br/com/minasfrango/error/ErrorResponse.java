package br.com.minasfrango.error;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private String title;
    private String detail;
    private int code;
    private String developerMessage;

}
