package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Embeddable
@Data
public class RecebimentoID implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -9171637624233664078L;

    @Transient
    private long id;

    @Column(name = "funcod", nullable = false)
    private long idFuncionario;
    @Column(name = "clicod", nullable = false)
    private long idCliente;
    @Column(name = "vencod", nullable = false)
    private long idVenda;

}
