package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.ItemPedidoDTO;
import br.com.minasfrango.entity.ListaPedidoDTO;
import br.com.minasfrango.entity.PedidoDTO;
import br.com.minasfrango.repository.ItemPedidoRepository;
import br.com.minasfrango.repository.PedidoRepository;

@RestController
@RequestMapping(path = "/rest/minasFrango")

public class ExportacaoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @PostMapping(value = "/exportaPedido")
    public boolean exportaPedido(@RequestBody ListaPedidoDTO pedidos) {

        try {

            for (int i = 0; i < pedidos.getPedidosDTO().size(); i++) {

                PedidoDTO pedidoSave = pedidoRepository.save(pedidos.getPedidosDTO().get(i));

                for (int j = 0; j < pedidos.getPedidosDTO().get(i).getItens().size(); j++) {
                    ItemPedidoDTO itemSave = itemPedidoRepository.save(pedidos.getPedidosDTO().get(i).getItens().get(j));

                }

            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
