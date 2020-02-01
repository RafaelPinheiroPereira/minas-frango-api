package br.com.minasfrango.model;

import java.util.List;

import br.com.minasfrango.entity.ListaPedido;
import br.com.minasfrango.entity.Recebimento;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Exportacao {

    ListaPedido listaPedido;
    List<Recebimento> recebimentos;

}
