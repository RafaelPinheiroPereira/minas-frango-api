package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.repository.PedidoRepository;

@Service
public class ExportacaoService {

    @Autowired
    PedidoService PedidoService;
    @Autowired
    ItemPedidoService itemPedidoService;

    @Autowired
    PedidoRepository pedidoRepository;

}
