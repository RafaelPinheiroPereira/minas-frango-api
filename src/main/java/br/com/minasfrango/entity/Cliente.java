package br.com.minasfrango.entity;

import java.io.Serializable;

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
@Table(name = "clientes")
@NoArgsConstructor
@Data
public class Cliente implements Serializable {

    private static final long serialVersionUID = -5835341501816588891L;

    @Id
    @Column(name = "clicod", nullable = false)
    private double id;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;

    @Column(name = "clinom", nullable = false)
    private String nome;
    @Column(name = "cliraz", nullable = false)
    private String razaoSocial;

    @ManyToOne
    @JoinColumn(name = "loccod", referencedColumnName = "loccod", insertable = false, updatable = false)
    private Localidade localidade;

    @Column(name = "cliend", nullable = false)
    private String endereco;

    @Column(name = "clinum", nullable = false)
    private String numero;

    @Column(name = "clibai", nullable = false)
    private String bairro;

    @Column(name = "clicid", nullable = false)
    private String cidade;

    @Column(name = "clicep", nullable = false)
    private String cep;

    @Column(name = "cliref", nullable = false)
    private String referencia;
    @Column(name = "clifon", nullable = false)
    private String telefone;

    @Column(name = "clicpf", nullable = false)
    private String cpf;

    @Column(name = "gpccod", nullable = false)
    private double codigoClienteGrupo;

}
