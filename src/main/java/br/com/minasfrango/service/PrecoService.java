package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Preco;
import br.com.minasfrango.repository.PrecoRepository;

@Service
public class PrecoService {

    @Autowired
    PrecoRepository precoRepository;

    public List<Preco> consultarPrecos(long idEmpresa, long idNucleo) {

        List<Preco> precos = precoRepository.pesquisarPrecos(idEmpresa, idNucleo);
        return precos;
    }

}
