package br.com.minasfrango.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "precos")
@Data
public class Preco {

    @EmbeddedId
    PrecoID chavesPreco;

    @Column(name = "prcval")
    private double valor;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;

    @Column(name = "nuccod", nullable = false)
    private long idNucleo;

}
