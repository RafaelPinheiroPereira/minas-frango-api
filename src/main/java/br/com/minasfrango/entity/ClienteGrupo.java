package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "clientegrupos")
@NoArgsConstructor
@Data
public class ClienteGrupo implements Serializable {

    private static final long serialVersionUID = -5835341501816588891L;

    @Id
    @Column(name = "gpccod", nullable = false)
    private double id;
    @Column(name = "gpcnom", nullable = false)
    private String nome;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;

}
