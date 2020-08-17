package br.com.minasfrango.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "localidades")
@Data
public class Localidade {

    @EmbeddedId
    LocalidadeID pkLocalidade;
    @Column(name = "locnom")
    private String nome;

}
