package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecebimentoDTO implements Serializable {

    private long idFuncionario;
    private long idCliente;
    private long idVenda;
    private Date dataVenda;
    private double valorVenda;
    private Date dataVencimento;

    public static RecebimentoDTO transformaEmRecebimentoDTO(Pedido pedido) {
        return new RecebimentoDTO(pedido.getCodigoFuncionario(), (long) pedido.getCodigoCliente(), pedido.getId(), pedido.getDataPedido(),
            pedido.getValorTotal(), pedido.getDataVencimento());
    }

}
