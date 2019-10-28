package br.com.minasfrango.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Component
@Table(name = "clientevendedores")

@Data
public class ClienteFuncionario implements Serializable {

    private static final long serialVersionUID = -5835341501816588891L;

    @EmbeddedId
    ClienteFuncionarioID chavesClienteFuncionario;

    @Column(name = "cliprz")
    private double clipRZ;

}
