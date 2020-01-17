package br.com.minasfrango.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Empresa;
import br.com.minasfrango.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRespository;

    public Empresa verificarStatusDaEmpresa(String cnpj, Date dataAtual) {
        // TODO Auto-generated method stub
        return empresaRespository.verificarStatusDaEmpresa(cnpj, dataAtual);
    }

}
