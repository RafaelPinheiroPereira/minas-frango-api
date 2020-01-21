package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

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

}
