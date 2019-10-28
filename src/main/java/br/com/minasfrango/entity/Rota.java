package br.com.minasfrango.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Component
@Table(name = "rotas")
@NoArgsConstructor
@Data
public class Rota {

    @Id
    @Column(name = "rotcod")
    private double id;

    @ManyToOne
    @JoinColumn(name = "funcod", referencedColumnName = "funcod")
    private Funcionario funcionario;

    @Column(name = "rotnom")
    private String nome;

}
