package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Double> {

    @Query(
        value = "SELECT p.* FROM produtos p,precos pr, unidades un "
            + "WHERE  p.procod=pr.procod "
            + "and p.pround =pr.pround   "
            + "and un.procod=p.procod"
            + " group by un.undcod",
        nativeQuery = true)
    public List<Produto> pesquisarProdutos();

}
