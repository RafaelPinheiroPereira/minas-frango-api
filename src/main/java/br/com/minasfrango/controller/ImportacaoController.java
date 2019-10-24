package br.com.minasfrango.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Cliente;
import br.com.minasfrango.entity.PedidoDTO;
import br.com.minasfrango.entity.Preco;
import br.com.minasfrango.entity.Produto;
import br.com.minasfrango.entity.RecebimentoDTO;
import br.com.minasfrango.entity.Rota;
import br.com.minasfrango.entity.TipoRecebimento;
import br.com.minasfrango.entity.Unidade;
import br.com.minasfrango.model.Importacao;
import br.com.minasfrango.repository.ClienteRepository;
import br.com.minasfrango.repository.PedidoRepository;
import br.com.minasfrango.repository.PrecoRepository;
import br.com.minasfrango.repository.ProdutoRepository;
import br.com.minasfrango.repository.RotaRepository;
import br.com.minasfrango.repository.TipoRecebimentoRepository;
import br.com.minasfrango.repository.UnidadeRepository;

@RestController
@RequestMapping(path = "/api/importacoes")
public class ImportacaoController {

    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    RotaRepository rotaRepository;
    @Autowired
    PedidoRepository pedidoRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    TipoRecebimentoRepository tipoRecebimentoRepository;

    @Autowired
    UnidadeRepository unidadeRepository;

    @Autowired
    PrecoRepository precoRepository;

    @GetMapping("/funcionarios")
    @ResponseBody
    public ResponseEntity<Importacao> realizarImportacao(@RequestParam(value = "id") long id) {

        Importacao importacao = new Importacao();

        importacao.setClientes(this.importarClientesDoFuncionario(id));
        importacao.setPrecos(this.importarPrecos());
        importacao.setProdutos(this.importarProdutos());
        importacao.setRecebimentosDTO(this.importarRecebimentosDoFuncionario(id));
        importacao.setRotas(this.importarRotasDoFuncionario(id));
        importacao.setUnidades(this.importarUnidades());
        importacao.setTiposRecebimento(this.importarTiposRecebimento());

        return ResponseEntity.status(HttpStatus.OK).body(importacao);

    }

    private List<RecebimentoDTO> importarRecebimentosDoFuncionario(double id) {

        return this.consultarRecebimentos(id);
    }

    private List<Rota> importarRotasDoFuncionario(double id) {

        return this.consultarRotas(id);
    }

    private List<Produto> importarProdutos() {

        List<Produto> produtos = produtoRepository.pesquisarProdutos();
        return produtos;
    }

    private List<TipoRecebimento> importarTiposRecebimento() {
        List<TipoRecebimento> tipos = tipoRecebimentoRepository.findAll();
        return tipos;
    }

    private List<Unidade> importarUnidades() {

        List<Unidade> unidades = unidadeRepository.consultarUnidadePorProdutoEPreco();
        return unidades;
    }

    private List<Preco> importarPrecos() {

        List<Preco> precos = precoRepository.pesquisarPrecos();
        return precos;
    }

    private List<Cliente> importarClientesDoFuncionario(long id) {

        return this.consultarClientes(id);

    }

    public List<Cliente> consultarClientes(long id) {

        List<Cliente> clientes = clienteRepository.pesquisarClientesPorFuncionario(id);
        return clientes;

    }

    public List<Rota> consultarRotas(double id) {

        List<Rota> rotas = rotaRepository.pesquisarRotaPorFuncionario(id);
        return rotas;
    }

    public List<RecebimentoDTO> consultarRecebimentos(double id) {

        List<PedidoDTO> pedidoDTOs = pedidoRepository.findAllRecebimentos(id);
        List<RecebimentoDTO> recebimentoDTOs = new ArrayList<RecebimentoDTO>();
        for (PedidoDTO pedidoDTO : pedidoDTOs) {
            recebimentoDTOs.add(RecebimentoDTO.transformaEmRecebimentoDTO(pedidoDTO));
        }
        return recebimentoDTOs;
    }

}
