package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Pedido;
import br.com.minasfrango.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoService itemPedidoService;

    public void salvar(Pedido pedido) {

        pedidoRepository.save(pedido);
        pedido.getItens().forEach(itemPedido -> {
            itemPedidoService.salvar(itemPedido);

        });

    }

}
