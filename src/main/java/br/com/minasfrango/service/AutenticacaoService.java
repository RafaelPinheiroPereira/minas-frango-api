package br.com.minasfrango.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.Funcionario;

@Service
public class AutenticacaoService {

    @Autowired
    FuncionarioService funcionarioService;

    public boolean autenticar(double id, String senha) {

        Optional<Funcionario> optionalFuncionario = funcionarioService.consultarPorId(id);

        if (optionalFuncionario.isPresent()) {
            funcionarioService.obterSenha(optionalFuncionario.get(), senha);

        } else {
            return false;
        }
        return optionalFuncionario.get().getSenha().equals(senha) ? true : false;

    }

}
