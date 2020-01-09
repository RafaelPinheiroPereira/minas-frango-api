package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.ClienteGrupo;

@Repository
public interface ClienteGrupoRepository extends JpaRepository<ClienteGrupo, Double> {

}
