package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class PrecoID implements Serializable {

    @Column(name = "tabcod")
    private double id;
    @Column(name = "procod")
    private double idProduto;
    @Column(name = "pround")
    private String unidadeProduto;
    @Column(name = "clicod")
    private double idCliente;

    @Column(name = "prcdat")
    private Date dataPreco;

}
