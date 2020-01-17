package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "dispositvos")
@NoArgsConstructor
@Data
public class Dispositivo implements Serializable {

    @Id
    @Column(name = "dismac", nullable = false)
    private String mac;

    @Column(name = "disapl", nullable = false)
    private String nome;

    @Column(name = "diseqp", nullable = false)
    private String descricao;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;
    @Column(name = "disini", nullable = false)
    private Date dataInicio;
    @Column(name = "disfim", nullable = false)
    private Date dataFim;

    @Transient
    private String ativo;

}
