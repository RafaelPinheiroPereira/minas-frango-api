package br.com.minasfrango.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Empresa;
import br.com.minasfrango.entity.Nucleo;
import br.com.minasfrango.repository.EmpresaRepository;

@Service
public class ConfiguracaoService {

    @Autowired
    EmpresaRepository empresaRepository;
    @Autowired
    NucleoService nucleoService;

    public boolean estaAtivo(String cnpj) {
        Optional<Empresa> optionalEmpresa = Optional.ofNullable(empresaRepository.findOne(cnpj));
        return optionalEmpresa.isPresent();
    }

    public List<Nucleo> pesquisarNucleoPorCNPJ(String cnpj) {
        return nucleoService.pesquisarNucleoPorCNPJ(cnpj);
    }

    public Empresa pesquisarEmpresaPorCNPJ(String cnpj) {

        return empresaRepository.findOne(cnpj);
    }

}
