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
@Table(name = "vendas")
@NoArgsConstructor
@Data
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "venseq", nullable = false)
    private long id;

    @Column(name = "empcod", nullable = false)
    private long idEmpresa;

    @Column(name = "vendat")
    private Date dataVenda;

    @Column(name = "funcod")
    private long codigoFuncionario;

    @Column(name = "clicod")
    private long codigoCliente;

    @Column(name = "ventot")
    private double valorTotal;

    @Column(name = "venamo")
    private double valorAmortizado;

    @Column(name = "nuccod")
    private double idNucleo;

    @Column(name = "venven")
    private Date dataVencimento;

    @Column(name = "venped")
    private long idPedidoBloco;

    @Column(name = "vencod")
    private long idVenda;

}
