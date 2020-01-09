package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.model.Importacao;
import br.com.minasfrango.service.ClienteGrupoService;
import br.com.minasfrango.service.ContaService;
import br.com.minasfrango.service.FuncionarioService;
import br.com.minasfrango.service.PrecoService;
import br.com.minasfrango.service.ProdutoService;
import br.com.minasfrango.service.TipoRecebimentoService;
import br.com.minasfrango.service.UnidadeService;

@RestController
@RequestMapping(path = "api/importacoes")
public class ImportacaoController {

    @Autowired
    PrecoService precoService;

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    UnidadeService unidadeService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    ContaService contaService;

    @Autowired
    TipoRecebimentoService tipoRecebimentoService;

    @Autowired
    ClienteGrupoService clienteGrupoService;

    @GetMapping("/funcionarios")
    @ResponseBody
    public ResponseEntity<Importacao> realizarImportacao(@RequestParam(value = "id") long id) {

        Importacao importacao = new Importacao();

        importacao.setClientes(funcionarioService.consultarClientes());
        importacao.setPrecos(precoService.consultarPrecos());
        importacao.setProdutos(produtoService.consultarProdutos());
        importacao.setRecebimentosDTO(funcionarioService.consultarRecebimentos(id));

        importacao.setUnidades(unidadeService.consultarUnidadePorProdutoEPreco());
        importacao.setContas(contaService.getContas());
        importacao.setClientesGrupos(clienteGrupoService.getClientesGrupos());

        return ResponseEntity.status(HttpStatus.OK).body(importacao);

    }

}
