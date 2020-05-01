package br.com.minasfrango.service;

import java.time.LocalDateTime;
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

        return vendaRepository.pesquisarTodosRecebimentosDoFuncionario(idNucleo, idEmpresa);

    }

    public LocalDateTime pesquisarDataMaximaUltimaSincronizacao(double id, long idEmpresa) {
        // TODO Auto-generated method stub
        return vendaRepository.pesquisarDataDaUltimaSincronizacao(id, idEmpresa);
    }

}
