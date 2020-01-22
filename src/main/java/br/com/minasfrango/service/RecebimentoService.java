package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Recebimento;
import br.com.minasfrango.repository.RecebimentoRepository;

@Service
public class RecebimentoService {

    @Autowired
    RecebimentoRepository recebimentoRepository;

    public void salvar(Recebimento recebimento) {
        recebimentoRepository.save(recebimento);
    }

    public Recebimento consultarRecebimentoPorCodigoVendaCodigoFuncionario(Recebimento recebimento) {
        // TODO Auto-generated method stub
        return recebimentoRepository.consultarReciboPorCodigoVendaCodigoFuncionario(recebimento.getIdVenda(), recebimento.getIdFuncionario(),
            recebimento.getIdRecibo());
    }

}
