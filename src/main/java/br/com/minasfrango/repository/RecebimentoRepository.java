package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Recebimento;

@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {

    @Query(value = "SELECT r.* FROM recibos r WHERE  r.vencod=?1 and r.funcod=?2 and r.numrec=?3",
        nativeQuery = true)
    public Recebimento consultarReciboPorCodigoVendaCodigoFuncionario(long idVenda, long idFuncionario, long idRecibo);

}
