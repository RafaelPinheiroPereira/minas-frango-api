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
@Table(name = "contas")
@NoArgsConstructor
@Data
public class Conta implements Serializable {

    @Id
    @Column(name = "concod", nullable = false)
    private String id;

    @Column(name = "condes", nullable = false)
    private String descricao;
    @Column(name = "conage", nullable = false)
    private String agencia;
    @Column(name = "concon", nullable = false)
    private String conta;

}
