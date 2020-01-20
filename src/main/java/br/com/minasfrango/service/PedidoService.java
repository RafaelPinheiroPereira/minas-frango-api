package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Pedido;
import br.com.minasfrango.repository.PedidoRepository;
import br.com.minasfrango.repository.RecebimentoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemPedidoService itemPedidoService;

    @Autowired
    RecebimentoRepository recebimentoRepository;

    public void salvar(Pedido pedido) {

        pedido.setMigrado(0);
        Pedido pedidoSalvo = pedidoRepository.save(pedido);

        pedido.getItens().forEach(itemPedido -> {

            itemPedido.getChavesItemPedido().setVenSeq(pedidoSalvo.getId());
            itemPedido.getChavesItemPedido().setIdVenda(pedidoSalvo.getIdVenda());

            itemPedidoService.salvar(itemPedido);

        });

    }

    public Pedido consultarPedidoPorCodigoVendaCodigoFuncionario(Pedido pedido) {

        return pedidoRepository.consultarPedidoPorCodigoVendaCodigoFuncionario(pedido.getIdVenda(),
            pedido.getCodigoFuncionario());

    }

}
