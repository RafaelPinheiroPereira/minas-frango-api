package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Funcionario;

@Service
public class AutenticacaoService {

    @Autowired
    FuncionarioService funcionarioService;

    public boolean autenticar(double id, String senha) {

        Funcionario funcionario = funcionarioService.consultarPorId(id);

        funcionarioService.obterSenha(funcionario, senha);

        return funcionario.getSenha().equals(senha) ? true : false;

    }

}
