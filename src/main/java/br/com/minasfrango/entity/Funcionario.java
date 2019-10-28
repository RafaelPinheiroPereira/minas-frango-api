package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "funcionarios")
@NoArgsConstructor
@Data
public class Funcionario implements Serializable {

    private static final long serialVersionUID = -6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcod", nullable = false)
    private double id;

    @Column(name = "funsen", nullable = false)
    @JsonIgnore
    @Getter
    private String senha;

    @Column(name = "funnom", nullable = false)
    private String nome;

    @Column(name = "funtip", nullable = false)
    private String tipoFuncionario;

    public Funcionario(Long id, String senha) {
        super();
        this.id = id;
        this.senha = senha;
    }

}
