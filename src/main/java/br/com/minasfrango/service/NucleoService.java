package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Nucleo;
import br.com.minasfrango.repository.NucleoRepository;

@Service
public class NucleoService {

    @Autowired
    NucleoRepository nucleoRepository;

    public List<Nucleo> pesquisarNucleoPorCNPJ(String cnpj) {
        // TODO Auto-generated method stub
        return nucleoRepository.pesquisarNucleoPorCNPJ(cnpj);
    }

}
