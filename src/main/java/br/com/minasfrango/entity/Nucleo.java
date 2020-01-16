package br.com.minasfrango.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "nucleos")
@NoArgsConstructor
@Data
public class Nucleo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuccod", nullable = false)
    private long id;
    @Column(name = "nucnom", nullable = false)
    private String nome;
    @Column(name = "empcnpj", nullable = false)
    private String cnpj;
    @Column(name = "nucdti", nullable = false)
    private Date dataInicio;
    @Column(name = "nucdtf", nullable = false)
    private Date dataFim;

}
