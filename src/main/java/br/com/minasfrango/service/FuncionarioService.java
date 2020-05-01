package br.com.minasfrango.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Cliente;
import br.com.minasfrango.entity.Funcionario;
import br.com.minasfrango.entity.RecebimentoDTO;
import br.com.minasfrango.entity.Rota;
import br.com.minasfrango.entity.Venda;
import br.com.minasfrango.error.MyResourceNotFoundException;
import br.com.minasfrango.repository.ClienteRepository;
import br.com.minasfrango.repository.FuncionarioRepository;
import br.com.minasfrango.repository.PedidoRepository;
import br.com.minasfrango.repository.RecebimentoRepository;
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
    RecebimentoRepository recebimentoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    VendaService vendaService;

    public List<Cliente> consultarClientes(long idEmpresa) {

        List<Cliente> clientes = clienteRepository.pesquisarClientesPorRede(idEmpresa);
        return clientes;

    }

    public long pesquisarCodigoMaximoDeVendaDoFuncionario(Funcionario funcionario) {
        return funcionarioRespository.pequisarMaximoIdVenda(funcionario.getId(), funcionario.getIdEmpresa());
    }

    public List<Rota> consultarRotas(double id) {
        List<Rota> rotas = rotaRepository.pesquisarRotaPorFuncionario(id);
        return rotas;

    }

    public List<RecebimentoDTO> consultarRecebimentos(long id, long idNucleo, long idEmpresa) {

        List<Venda> vendas = vendaService.pesquisarRecebimentosDoFuncionario(id, idNucleo, idEmpresa);
        List<RecebimentoDTO> recebimentoDTOs = new ArrayList<RecebimentoDTO>();
        for (Venda venda : vendas) {
            recebimentoDTOs.add(RecebimentoDTO.transformaEmRecebimentoDTO(venda));
        }
        return recebimentoDTOs;
    }

    public Funcionario pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(double id, long idEmpresa) {

        return Optional.ofNullable(funcionarioRespository.pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(id, idEmpresa))
            .orElseThrow(() -> new MyResourceNotFoundException("Funcionario nao encontrado"));

    }

    public String obterSenha(Funcionario funcionario) {
        return Optional.ofNullable(funcionario.getSenha()).orElseThrow(() -> new MyResourceNotFoundException("Funcionario sem senha"));
    }

    public long pesquisarCodigoMaximoDeReciboDoFuncionario(Funcionario funcionarioPesquisado) {
        // TODO Auto-generated method stub
        return funcionarioRespository.pesquisarMaximoIdRecibo(funcionarioPesquisado.getId(), funcionarioPesquisado.getIdEmpresa());
    }

    public void atualizarDataUltimaSincronizacao(double id, LocalDateTime dataUltimaSincronizacao) {
        funcionarioRespository.atualizarDataUltimaSincronizacao(id, dataUltimaSincronizacao);

    }

}
