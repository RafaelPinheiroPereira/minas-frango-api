package br.com.minasfrango.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Cliente;
import br.com.minasfrango.entity.Funcionario;
import br.com.minasfrango.entity.PedidoDTO;
import br.com.minasfrango.entity.RecebimentoDTO;
import br.com.minasfrango.entity.Rota;
import br.com.minasfrango.error.MyResourceNotFoundException;
import br.com.minasfrango.repository.ClienteRepository;
import br.com.minasfrango.repository.FuncionarioRepository;
import br.com.minasfrango.repository.PedidoRepository;
import br.com.minasfrango.repository.RotaRepository;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioRepository funcionarioRespository;
    @Autowired
    RotaRepository rotaRepository;

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public List<Cliente> consultarClientes(long id) {

        List<Cliente> clientes = clienteRepository.pesquisarClientesPorFuncionario(id);
        return clientes;

    }

    public List<Rota> consultarRotas(double id) {
        List<Rota> rotas = rotaRepository.pesquisarRotaPorFuncionario(id);
        return rotas;

    }

    public List<RecebimentoDTO> consultarRecebimentos(double id) {

        List<PedidoDTO> pedidoDTOs = pedidoRepository.findAllRecebimentos(id);
        List<RecebimentoDTO> recebimentoDTOs = new ArrayList<RecebimentoDTO>();
        for (PedidoDTO pedidoDTO : pedidoDTOs) {
            recebimentoDTOs.add(RecebimentoDTO.transformaEmRecebimentoDTO(pedidoDTO));
        }
        return recebimentoDTOs;
    }

    public Funcionario consultarPorId(double id) {

        return Optional.ofNullable(funcionarioRespository.findOne(id))
            .orElseThrow(() -> new MyResourceNotFoundException("Funcionario nao encontrado"));

    }

    public String obterSenha(Funcionario funcionario, String senha) {
        return Optional.ofNullable(funcionario.getSenha()).orElseThrow(() -> new MyResourceNotFoundException("Funcionario sem senha"));
    }

}
