package br.com.minasfrango.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, String> {

    @Query(
        value = "SELECT d.* FROM dispositivos d "
            + "WHERE  d.dismac=?1 and d.disfim>=?2 ",
        nativeQuery = true)
    List<Dispositivo> pesquisarDispositivosAtivos(String mac, Date dataAtual);

}
