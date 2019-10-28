package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.ClienteFuncionario;
import br.com.minasfrango.entity.ClienteFuncionarioID;

@Repository
public interface ClienteFuncionarioRepository extends JpaRepository<ClienteFuncionario, ClienteFuncionarioID> {

}
