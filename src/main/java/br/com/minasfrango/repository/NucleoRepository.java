package br.com.minasfrango.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Nucleo;

@Repository
public interface NucleoRepository extends JpaRepository<Nucleo, Long> {

    @Query(value = "SELECT n.* FROM nucleos n "
        + "WHERE  n.empcnpj=?1 and n.nucdtf>=?2",
        nativeQuery = true)
    List<Nucleo> pesquisarNucleoPorCNPJ(String cnpj, Date dataAtual);

}
