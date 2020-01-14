package br.com.minasfrango.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Empresa;
import br.com.minasfrango.entity.Nucleo;
import br.com.minasfrango.model.Configuracao;
import br.com.minasfrango.service.ConfiguracaoService;

@RestController
@RequestMapping(path = "api/configuracoes")
public class ConfiguracaoController {

    @Autowired
    ConfiguracaoService configuracaoService;

    @GetMapping(value = "/ativada")
    @ResponseBody
    public ResponseEntity<?> verificarAtivacao(@RequestParam(value = "cnpj") String cnpj) {

        if (configuracaoService.estaAtivo(cnpj)) {
            // acesso autorizado

            Empresa empresa = configuracaoService.pesquisarEmpresaPorCNPJ(cnpj);

            Optional<List<Nucleo>> optionalNucleos = Optional.ofNullable(configuracaoService.pesquisarNucleoPorCNPJ(cnpj));
            if (optionalNucleos.isPresent()) {
                empresa.setNucleos(optionalNucleos.get());
            } else {
                empresa.setNucleos(new ArrayList<Nucleo>());
            }

            return new ResponseEntity<>(new Configuracao(empresa), HttpStatus.OK);

        } else {
            // acesso nao autorizado
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }

}
