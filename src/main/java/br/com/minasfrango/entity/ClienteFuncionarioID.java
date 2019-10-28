package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class ClienteFuncionarioID implements Serializable {

    /**
     * 
     */

    private static final long serialVersionUID = -664886163053681970L;

    @Column(name = "clicod")
    private double codigoCliente;
    @Column(name = "funcod")
    private double codigoFuncionario;

    @Column(name = "tprcod")
    private double tprCod;

}
