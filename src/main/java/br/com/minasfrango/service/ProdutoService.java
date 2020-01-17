package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Produto;
import br.com.minasfrango.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<Produto> consultarProdutos(long idEmpresa, long idNucleo) {

        List<Produto> produtos = produtoRepository.pesquisarProdutos(idEmpresa, idNucleo);
        return produtos;
    }

}
