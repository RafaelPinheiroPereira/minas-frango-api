package br.com.minasfrango.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.model.Exportacao;
import br.com.minasfrango.service.ExportacaoService;
import br.com.minasfrango.service.PedidoService;
import br.com.minasfrango.service.RecebimentoService;

@RestController
@RequestMapping(path = "api/exportacoes")

public class ExportacaoController {

    @Autowired
    ExportacaoService exportacaoService;

    @Autowired
    PedidoService pedidoService;

    @Autowired
    RecebimentoService recebimentoService;

    @PostMapping(value = "/pedidos")
    public boolean exportarPedido(@RequestBody Exportacao exportacao) {

        try {
            exportacao.getListaPedido().getPedidos().forEach(pedido -> {
                pedidoService.salvar(pedido);
            });

            exportacao.getRecebimentos().forEach(recebimento -> {
                recebimentoService.salvar(recebimento);
            });
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
