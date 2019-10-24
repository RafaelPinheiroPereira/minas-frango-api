package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "recibos")
@Data
public class Recebimento implements Serializable {

    @EmbeddedId
    RecebimentoID chavesRecebimento;

    @Column(name = "numrec")
    private long id;

    @Column(name = "datrec")
    private Date dataRecebimento;
    @Column(name = "valamo")
    private double valorAmortizado;

    @Column(name = "tprcod")
    private double tipoRecebimento;

}
