package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Double> {

    @Query(value = "SELECT c.* FROM clientes c,clientegrupos cg "
        + "WHERE c.gpccod=cg.gpccod and c.empcod=cg.empcod and cg.empcod=?1 ",
        nativeQuery = true)
    public List<Cliente> pesquisarClientesPorRede(long idEmpresa);

}
