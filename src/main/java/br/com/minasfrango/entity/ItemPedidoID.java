package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Embeddable
@Data

public class ItemPedidoID implements Serializable {

    private static final long serialVersionUID = -664886163053681970L;

    @Transient
    private long id;

    @Column(name = "vencod", nullable = false)
    private double idVenda;
    @Column(name = "procod", nullable = false)
    private double idProduto;
    @Column(name = "pround", nullable = false)
    private String idUnidade;
    @Column(name = "vendat", nullable = false)
    private Date dataVenda;

    @Column(name = "ventip", nullable = false)
    private String tipoVenda;
    @Column(name = "nuccod", nullable = false)
    private String nucleoCodigo;

    @Column(name = "venseq", nullable = false)
    private double venSeq;

}
