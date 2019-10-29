package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Recebimento;

@Repository
public interface RecebimentoRepository extends JpaRepository<Recebimento, Long> {

}
