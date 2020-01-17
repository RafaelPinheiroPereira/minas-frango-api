package br.com.minasfrango.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Dispositivo;
import br.com.minasfrango.repository.DispositivoRepository;

@Service
public class DispositivoService {

    @Autowired
    DispositivoRepository dispositivoRepository;

    public List<Dispositivo> pesquisarDispositivosAtivos(String mac, Date dataAtual) {
        // TODO Auto-generated method stub
        return dispositivoRepository.pesquisarDispositivosAtivos(mac, dataAtual);
    }
}
