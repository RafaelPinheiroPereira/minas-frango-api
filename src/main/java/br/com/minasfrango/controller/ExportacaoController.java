package br.com.minasfrango.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Pedido;
import br.com.minasfrango.entity.Recebimento;
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

                Optional<Pedido> optionalPedidoToSave = Optional.ofNullable(pedidoService.consultarPedidoPorCodigoVendaCodigoFuncionario(pedido));

                if (optionalPedidoToSave.isPresent()) {

                    /** Realizar update */
                    pedido.setId(optionalPedidoToSave.get().getId());

                    Optional<Integer> optionalCodigoMigrado = Optional.ofNullable(optionalPedidoToSave.get().getMigrado());

                    if (optionalCodigoMigrado.isPresent() && optionalCodigoMigrado.get().intValue() == 0) {
                        pedidoService.salvar(pedido);

                    }

                }
                /** Realizar insert */
                else
                    pedidoService.salvar(pedido);

            });

            System.out.println(exportacao);

            exportacao.getRecebimentos().forEach(recebimento -> {

                Optional<Recebimento> optionalRecebimentoToSave = Optional
                    .ofNullable(recebimentoService.consultarRecebimentoPorCodigoVendaCodigoFuncionario(recebimento));
                if (optionalRecebimentoToSave.isPresent()) {

                    /** Realizar update */
                    recebimento.setId(optionalRecebimentoToSave.get().getId());

                    Optional<Integer> optionalCodigoMigrado = Optional.ofNullable(optionalRecebimentoToSave.get().getMigrado());

                    if (optionalCodigoMigrado.isPresent() && optionalCodigoMigrado.get().intValue() == 0) {
                        recebimento.setMigrado(0);
                        recebimentoService.salvar(recebimento);

                    }

                } else {
                    recebimento.setMigrado(0);
                    recebimentoService.salvar(recebimento);
                }
            });

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

}
