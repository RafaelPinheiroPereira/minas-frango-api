package br.com.minasfrango.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Dispositivo;
import br.com.minasfrango.entity.Empresa;
import br.com.minasfrango.entity.Nucleo;
import br.com.minasfrango.repository.EmpresaRepository;

@Service
public class ConfiguracaoService {

    @Autowired
    EmpresaRepository empresaRepository;

    @Autowired
    EmpresaService empresaService;
    @Autowired
    NucleoService nucleoService;

    @Autowired
    DispositivoService dispositivoService;

    public List<Nucleo> pesquisarNucleosAtivos(String cnpj, Date dataAtual) {
        return nucleoService.pesquisarNucleosAtivos(cnpj, dataAtual);
    }

    public Empresa verificarAtivacaoDaEmpresa(String cnpj, Date dataAtual) {

        return empresaService.verificarStatusDaEmpresa(cnpj, dataAtual);
    }

    public List<Dispositivo> pesquisarDispositivosAtivos(String mac, Date dataAtual) {
        // TODO Auto-generated method stub
        return dispositivoService.pesquisarDispositivosAtivos(mac, dataAtual);
    }

}
