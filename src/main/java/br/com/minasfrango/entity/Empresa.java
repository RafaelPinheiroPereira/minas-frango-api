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

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "empresas")
@NoArgsConstructor
@Data
public class Empresa implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -6120725283884228689L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empcod", nullable = false)
    private long id;
    @Column(name = "empcnpj", nullable = false)
    private String cnpj;
    @Column(name = "empnom", nullable = false)
    private String nome;
    @Column(name = "empdti", nullable = false)

    private Date dataInicio;

    @Column(name = "empdtf", nullable = false)

    private Date dataFim;

    @Transient
    private List<Nucleo> nucleos;

    @Transient
    private List<Dispositivo> dispositivos;

    @Transient

    private String ativo;

}
