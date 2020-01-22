package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.repository.RecebimentoRepository;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    @Autowired
    RecebimentoRepository recebimentoRepository;

    @GetMapping()
    public String verificarStatusAplicacao() {

        return " Api Minas Frango";
    }

}
