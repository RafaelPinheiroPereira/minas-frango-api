package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.minasfrango.entity.Conta;

public interface ContaRepository extends CrudRepository<Conta, Double> {

    @Query(
        value = "SELECT c.* FROM contas c",
        nativeQuery = true)
    public List<Conta> pesquisarContas();
}
