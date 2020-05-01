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
    private long idPedidoBloco;
    private long idEmpresa;

    public static RecebimentoDTO transformaEmRecebimentoDTO(Venda venda) {

        // nuccod , empc e vencod colocar e venpend
        return new RecebimentoDTO(venda.getCodigoFuncionario(), venda.getCodigoCliente(), venda.getIdVenda(), venda.getDataVenda(),
            venda.getValorTotal() - venda.getValorAmortizado(), venda.getDataVencimento(), venda.getIdPedidoBloco(), venda.getIdEmpresa());
    }

}
