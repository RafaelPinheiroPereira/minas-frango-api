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
@Table(name = "recebimentotipos")
@NoArgsConstructor
@Data
public class TipoRecebimento implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = 977303606705819892L;
    @Id
    @Column(name = "tprcod", nullable = false)
    private double id;

    @Column(name = "tprnom", nullable = false)
    private String nome;

}
