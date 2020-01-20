package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Conta;
import br.com.minasfrango.repository.ContaRepository;

@Service
public class ContaService {

    @Autowired
    ContaRepository contaRepository;

    public List<Conta> getContas(long idEmpresa, long idNucleo) {

        return contaRepository.pesquisarContas(idEmpresa, idNucleo);
    }

}
