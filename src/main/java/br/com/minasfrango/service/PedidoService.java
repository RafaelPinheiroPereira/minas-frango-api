package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.PedidoDTO;
import br.com.minasfrango.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoService itemPedidoService;

    public void salvar(PedidoDTO pedidoDTO) {

        pedidoRepository.save(pedidoDTO);
        pedidoDTO.getItens().forEach(itemPedidoDTO -> {
            itemPedidoService.salvar(itemPedidoDTO);

        });

    }

}
