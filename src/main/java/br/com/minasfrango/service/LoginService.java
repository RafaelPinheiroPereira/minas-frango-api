package br.com.minasfrango.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minasfrango.entity.Funcionario;
import br.com.minasfrango.error.MyResourceNotFoundException;
import br.com.minasfrango.repository.FuncionarioRepository;

@RestController
@RequestMapping(path = "/rest/minasFrango")
public class LoginService {

    @Autowired
    FuncionarioRepository user;

    @GetMapping(value = "/funcionarios", produces = "application/json")
    @ResponseBody
    public ArrayList<Funcionario> getDadosLogin() {
        Iterable<Funcionario> inIterable = user.findAll();
        ArrayList<Funcionario> users = new ArrayList<>();
        for (Funcionario aux : inIterable) {
            users.add(aux);
        }
        return users;
    }

    @GetMapping(value = "/autenticacaoLogin")
    @ResponseBody
    public ResponseEntity<?> autenticarLogin(@RequestParam(value = "id") double id, @RequestParam(value = "senha") String senha) {

        verificaSeExisteFuncionario(id);

        Funcionario funcionario = user.findOne(id);

        verificaSeFuncionarioTemSenha(funcionario, senha);

        if (funcionario.getSenha().equals(senha))
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        else
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);

    }

    @GetMapping(value = "/hello")
    @ResponseBody
    public String sayHello() {
        return "Minas Frango - Rest Full Application.";
    }

    private void verificaSeExisteFuncionario(double id) {

        if (user.findOne(id) == null) {
            throw new MyResourceNotFoundException("Funcionario nao encontrado para o ID: " + id);
        }
    }

    private void verificaSeFuncionarioTemSenha(Funcionario funcionario, String senha) {
        Optional.ofNullable(funcionario.getSenha()).orElseThrow(() -> new MyResourceNotFoundException("Funcionario sem senha"));
    }

}
