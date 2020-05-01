package br.com.minasfrango.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

    @Query(value = "SELECT v.* FROM vendas v  "
        + "WHERE  v.ventot >v.venamo and  v.nuccod=?1 and v.empcod=?2",
        nativeQuery = true)
    public List<Venda> pesquisarTodosRecebimentosDoFuncionario(long idNucleo, long idEmpresa);

    @Query(value = "SELECT max(v.vendtsync) FROM vendas v "
        + "WHERE  v.funcod=?1  and v.empcod=?2 ",
        nativeQuery = true)
    public LocalDateTime pesquisarDataDaUltimaSincronizacao(double id, long idEmpresa);
}
