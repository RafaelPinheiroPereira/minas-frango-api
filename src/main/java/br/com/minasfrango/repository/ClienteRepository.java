package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Double> {

    @Query(value = "SELECT c.* FROM clientes c,localidades l, rotas r "
        + "WHERE c.loccod=l.loccod "
        + "and l.rotcod=r.rotcod "
        + "and r.funcod=?1",
        nativeQuery = true)
    public List<Cliente> pesquisarClientesPorFuncionario(long idFuncionario);
}
