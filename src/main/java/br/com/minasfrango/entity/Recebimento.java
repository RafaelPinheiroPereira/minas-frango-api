package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "recibos")
@Data
public class Recebimento implements Serializable {

    @Id
    @Column(name = "numrec")
    private long id;
    @Column(name = "funcod")
    private long idFuncionario;
    @Column(name = "clicod")
    private long idCliente;
    @Column(name = "vencod")
    private long idVenda;

    @Column(name = "datrec")
    private Date dataRecebimento;
    @Column(name = "valamo")
    private double valorAmortizado;

    @Column(name = "tprcod")
    private double tipoRecebimento;

    @Column(name = "concod")
    private String idConta;

}
