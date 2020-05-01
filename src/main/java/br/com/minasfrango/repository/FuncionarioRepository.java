package br.com.minasfrango.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.minasfrango.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Double> {

    @Query(value = "SELECT IFNULL(max(p.vencod),0) FROM funcionarios f, pedido p "
        + "WHERE  f.funcod=?1  and f.empcod=?2 and f.funcod=p.funcod ",
        nativeQuery = true)
    long pequisarMaximoIdVenda(double id, long idEmpresa);

    @Query(value = "SELECT f.* FROM funcionarios f "
        + "WHERE  f.funcod=?1  and f.empcod=?2",
        nativeQuery = true)
    public Funcionario pesquisarPorCodigoDoFuncionarioECodigoDaEmpresa(double id, long idEmpresa);

    @Query(value = "SELECT IFNULL(max(r.numrec),0) FROM funcionarios f, recibos r "
        + "WHERE  f.funcod=?1  and f.empcod=?2 and f.funcod=r.funcod ",
        nativeQuery = true)
    long pesquisarMaximoIdRecibo(double id, long idEmpresa);

    @Modifying
    @Transactional
    @Query(value = "update funcionarios f set f.FUNDTSYNC = :dataUltimaSincronizacao where f.funcod = :id",
        nativeQuery = true)
    public void atualizarDataUltimaSincronizacao(@Param("id") double id, @Param("dataUltimaSincronizacao") LocalDateTime dataUltimaSincronizacao);

}
