package br.com.minasfrango.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Double> {

}
