package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Unidade;
import br.com.minasfrango.entity.UnidadeProdutoID;

/**
 * @author Rafael Pinheiro Desenvolvido em 19 de out de 2018
 */
@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, UnidadeProdutoID> {

    @Query(value = "SELECT un.* FROM produtos p, unidades un "
        + "WHERE  un.empcod=?1 "
        + "and un.procod=p.procod  "
        + " group by un.undcod",
        nativeQuery = true)
    public List<Unidade> consultarUnidadePorProdutoEPreco(long idEmpresa, long idNucleo);

}
