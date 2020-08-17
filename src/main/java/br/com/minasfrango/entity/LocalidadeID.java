package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class LocalidadeID implements Serializable {

    @Column(name = "loccod")
    private long idLocalidade;

    @Column(name = "EMPCOD")
    private double idEmpresa;
}
