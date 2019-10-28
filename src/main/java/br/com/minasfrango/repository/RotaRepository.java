package br.com.minasfrango.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Rota;

@Repository
public interface RotaRepository extends JpaRepository<Rota, Double> {

    @Query(value = "SELECT r.* FROM rotas r "
        + "WHERE  r.funcod=?1",
        nativeQuery = true)
    public List<Rota> pesquisarRotaPorFuncionario(double idFuncionario);

}
