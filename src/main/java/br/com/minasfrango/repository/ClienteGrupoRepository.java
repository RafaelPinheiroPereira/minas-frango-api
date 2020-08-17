package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.ClienteGrupo;

@Repository
public interface ClienteGrupoRepository extends JpaRepository<ClienteGrupo, Double> {

    @Query(value = "SELECT cg.* FROM clientegrupos cg  where  cg.empcod=?1 "

        + "ORDER BY gpcnom DESC ",
        nativeQuery = true)
    public List<ClienteGrupo> pesquisarClienteGrupo(long idEmpresa);

}
