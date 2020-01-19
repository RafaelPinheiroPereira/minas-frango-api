package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Venda;
import br.com.minasfrango.repository.VendaRepository;

@Service
public class VendaService {

    @Autowired
    VendaRepository vendaRepository;

    public List<Venda> pesquisarRecebimentosDoFuncionario(long idFuncionario, long idNucleo, long idEmpresa) {

        return vendaRepository.pesquisarTodosRecebimentosDoFuncionario(idFuncionario, idNucleo, idEmpresa);

    }

}
