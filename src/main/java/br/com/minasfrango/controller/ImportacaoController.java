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
    public ResponseEntity<Importacao> realizarImportacao(@RequestParam(value = "id") long id, @RequestParam(value = "idEmpresa") long idEmpresa,
        @RequestParam(value = "idNucleo") long idNucleo) {

        Importacao importacao = new Importacao();

        importacao.setClientes(funcionarioService.consultarClientes(idEmpresa));
        importacao.setPrecos(precoService.consultarPrecos(idEmpresa, idNucleo));
        importacao.setProdutos(produtoService.consultarProdutos(idEmpresa, idNucleo));
        importacao.setRecebimentosDTO(funcionarioService.consultarRecebimentos(id, idNucleo, idEmpresa));

        importacao.setUnidades(unidadeService.consultarUnidadePorProdutoEPreco(idEmpresa, idNucleo));
        importacao.setContas(contaService.getContas(idEmpresa, idNucleo));
        importacao.setClientesGrupos(clienteGrupoService.getClientesGrupos());

        return ResponseEntity.status(HttpStatus.OK).body(importacao);

    }

}
