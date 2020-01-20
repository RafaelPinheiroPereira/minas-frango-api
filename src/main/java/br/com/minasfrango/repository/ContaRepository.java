package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Double> {

    @Query(
        value = "SELECT c.* FROM contas c where c.empcod=?1 and c.nuccod=?2 order by c.concon desc",
        nativeQuery = true)
    public List<Conta> pesquisarContas(long idEmpresa, long idNucleo);
}
