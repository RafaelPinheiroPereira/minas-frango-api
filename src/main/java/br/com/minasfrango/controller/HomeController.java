package br.com.minasfrango.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Venda;
import br.com.minasfrango.repository.VendaRepository;

@RestController
@RequestMapping(path = "/api")
public class HomeController {

    @Autowired
    VendaRepository vendaRepository;

    @GetMapping()
    public String verificarStatusAplicacao() {

        return " Api Minas Frango";
    }

    @GetMapping("/vendas")
    @ResponseBody
    public ResponseEntity<List<Venda>> getAllVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(vendaRepository.pesquisarTodosRecebimentosDoFuncionario(38, 4, 1));
    }

}
