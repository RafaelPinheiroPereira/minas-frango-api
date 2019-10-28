package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class UnidadeProdutoID implements Serializable {

    private static final long serialVersionUID = -664886163053681970L;

    @Column(name = "procod")
    private double idProduto;
    @Column(name = "undcod")
    private String idUnidade;

}
