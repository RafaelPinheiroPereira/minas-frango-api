package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Recebimento;
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

    @GetMapping("/recebimento")
    @ResponseBody
    public ResponseEntity<Recebimento> getAllVendas() {
        return ResponseEntity.status(HttpStatus.OK).body(recebimentoRepository.consultarReciboPorCodigoVendaCodigoFuncionario(761, 1));
    }

}
