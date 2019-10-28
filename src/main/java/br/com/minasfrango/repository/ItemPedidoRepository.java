package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.ItemPedidoDTO;
import br.com.minasfrango.entity.ItemPedidoIDDTO;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoDTO, ItemPedidoIDDTO> {

}
