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
@Table(name = "google_drive")
@NoArgsConstructor
@Data
public class ConfiguracaoGoogleDrive implements Serializable {

    @Id
    @Column(name = "id", nullable = false)
    private double id;
    @Column(name = "funcod", nullable = false)
    private long idFuncionario;
    @Column(name = "empcod", nullable = false)
    private long idEmpresa;
    @Column(name = "str_id_pasta_venda", nullable = false)
    private String idPastaVenda;
    @Column(name = "str_id_pasta_recibo", nullable = false)
    private String idPastaRecibo;
    @Column(name = "str_id_pasta_funcionario", nullable = false)
    private String idPastaFuncionario;

}
