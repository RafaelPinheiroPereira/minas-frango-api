package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Localidade;

@Repository
public interface LocalidadeRepository extends JpaRepository<Localidade, Double> {

}
