package br.com.minasfrango.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "localidades")
@Data
public class Localidade {

    @Id
    @Column(name = "loccod")
    private double id;
    @Column(name = "locnom")
    private String nome;

    @Column(name = "empcod")
    private long idEmpresa;

    @ManyToOne
    @JoinColumn(name = "rotcod", referencedColumnName = "rotcod")
    private Rota rota;

}
