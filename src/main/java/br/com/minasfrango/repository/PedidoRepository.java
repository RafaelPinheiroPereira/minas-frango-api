package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.PedidoDTO;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoDTO, Long> {

    @Query(value = "SELECT p.* FROM pedido p , clientes c "
        + "WHERE  p.clicod=c.clicod and p.ventot >p.venamo and p.funcod=?1",
        nativeQuery = true)
    public List<PedidoDTO> findAllRecebimentos(double idFuncionario);

}
