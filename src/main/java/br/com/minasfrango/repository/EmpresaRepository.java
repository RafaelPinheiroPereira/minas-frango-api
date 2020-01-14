package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, String> {

}
