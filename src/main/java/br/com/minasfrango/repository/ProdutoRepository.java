package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Double> {

    @Query(
        value = "SELECT p.* FROM produtos p where p.empcod=?1 and p.nuccod=?2",
        nativeQuery = true)
    public List<Produto> pesquisarProdutos(long idEmpresa, long idNucleo);

}
