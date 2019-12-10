package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.TipoRecebimento;
import br.com.minasfrango.repository.TipoRecebimentoRepository;

@Service
public class TipoRecebimentoService {

    @Autowired
    TipoRecebimentoRepository tipoRecebimentoRepository;

    public List<TipoRecebimento> consultarTiposRecebimento() {

        List<TipoRecebimento> tiposRecebimento = tipoRecebimentoRepository.findAll();
        return tiposRecebimento;
    }

}
