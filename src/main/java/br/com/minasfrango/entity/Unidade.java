package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author Rafael Pinheiro Desenvolvido em 19 de out de 2018
 */
@Entity
@Table(name = "unidades")
@Data
public class Unidade implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 1713997694369049955L;

    @EmbeddedId
    UnidadeProdutoID chavesUnidade;
    @Column(name = "UNDNOM")
    private String nome;
    @Column(name = "UNDPAD")
    private String unidadePadrao;

    @Column(name = "empcod")
    private long idEmpresa;
}
