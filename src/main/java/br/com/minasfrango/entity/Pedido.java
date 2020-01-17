package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "pedido")
@Data
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venseq", nullable = false)
    private long id;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;

    @Column(name = "vencod", nullable = false)
    private long idVenda;

    @Column(name = "vendat")
    private Date dataPedido;

    @Column(name = "funcod")
    private long codigoFuncionario;

    @Column(name = "clicod")
    private double codigoCliente;

    @Column(name = "ventot")
    private double valorTotal;

    @Column(name = "venamo")
    private double valorAmortizado;

    @Column(name = "tprcod")
    private double tipoRecebimento;
    @Column(name = "venven")
    private Date dataVencimento;

    @Column(name = "venmtc")
    private String motivoCancelamento;

    @Column(name = "venmig", columnDefinition = "double default 0")
    private Integer migrado;

    @Column(name = "nuccod")
    private long idNucleo;

    @Transient
    List<ItemPedido> itens;

}
