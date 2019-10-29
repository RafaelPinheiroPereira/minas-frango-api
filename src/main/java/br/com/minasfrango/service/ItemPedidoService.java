package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.ItemPedido;
import br.com.minasfrango.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    public void salvar(ItemPedido itemPedido) {
        itemPedidoRepository.save(itemPedido);

    }

}
