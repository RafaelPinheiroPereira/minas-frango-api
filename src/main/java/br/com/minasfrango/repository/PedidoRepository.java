package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    // nucleo + empcod
    @Query(value = "SELECT p.* FROM pedido p , clientes c "
        + "WHERE  p.clicod=c.clicod and p.ventot >p.venamo and p.funcod=?1",
        nativeQuery = true)
    public List<Pedido> findAllRecebimentos(double idFuncionario);

    @Query(value = "SELECT p.* FROM pedido p  "
        + "WHERE  p.vencod=?1 and p.funcod=?2",
        nativeQuery = true)
    public Pedido consultarPedidoPorCodigoVendaCodigoFuncionario(long codigoVenda, long codigoFuncionario);

}
