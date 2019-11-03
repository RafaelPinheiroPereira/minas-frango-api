package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "itemPedido")
@Data
public class ItemPedido implements Serializable {

    @EmbeddedId
    ItemPedidoID chavesItemPedido;

    @Transient
    private long id;
    @Column(name = "itvqtd")
    private double quantidade;
    @Transient
    private String descricao;
    @Column(name = "itvval")
    private double valorUnitario;
    @Column(name = "bicos")
    private double bicos;
    @Column(name = "lote")
    private String lote;
    @Transient
    private double valorTotal;

}
