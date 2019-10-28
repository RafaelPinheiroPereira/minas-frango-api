package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.ListaPedidoDTO;
import br.com.minasfrango.service.ExportacaoService;
import br.com.minasfrango.service.PedidoService;

@RestController
@RequestMapping(path = "api/exportacoes")

public class ExportacaoController {

    @Autowired
    ExportacaoService exportacaoService;

    @Autowired
    PedidoService pedidoService;

    @PostMapping(value = "/pedidos")
    public void exportarPedido(@RequestBody ListaPedidoDTO pedidos) {

        pedidos.getPedidosDTO().forEach(pedidoDTO -> {
            pedidoService.salvar(pedidoDTO);
        });
    }

}
