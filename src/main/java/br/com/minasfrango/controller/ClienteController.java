package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.repository.ClienteRepository;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

    @Autowired
    ClienteRepository clienteRepository;

}
