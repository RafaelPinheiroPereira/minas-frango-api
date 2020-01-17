package br.com.minasfrango.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {

    @Id
    @Column(name = "procod")
    private double id;
    @Column(name = "pronom")
    private String nome;

    @Column(name = "pround")
    private String unidade;
    @Column(name = "proqtd")
    private double quantidade;

    @Column(name = "empcod")
    private long idEmpresa;

    @Column(name = "nuccod")
    private long idNucleo;

}
