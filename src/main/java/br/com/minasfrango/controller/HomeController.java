package br.com.minasfrango.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    @GetMapping()
    public String verificarStatusAplicacao() {

        return " Api Minas Frango";
    }
}
