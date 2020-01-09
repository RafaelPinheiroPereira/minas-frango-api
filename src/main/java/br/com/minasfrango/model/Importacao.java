package br.com.minasfrango.model;

import java.util.List;

import br.com.minasfrango.entity.Cliente;
import br.com.minasfrango.entity.ClienteGrupo;
import br.com.minasfrango.entity.Conta;
import br.com.minasfrango.entity.Preco;
import br.com.minasfrango.entity.Produto;
import br.com.minasfrango.entity.RecebimentoDTO;
import br.com.minasfrango.entity.Unidade;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Importacao {

    List<Cliente> clientes;

    List<Produto> produtos;
    List<Unidade> unidades;
    List<Preco> precos;
    List<RecebimentoDTO> recebimentosDTO;
    List<Conta> contas;
    List<ClienteGrupo> clientesGrupos;

}
