package br.com.minasfrango.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.ClienteGrupo;
import br.com.minasfrango.repository.ClienteGrupoRepository;

@Service
public class ClienteGrupoService {

    @Autowired
    ClienteGrupoRepository clienteGrupoRepository;

    public List<ClienteGrupo> getClientesGrupos() {

        return clienteGrupoRepository.findAll();
    }

}
