package br.com.minasfrango.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.minasfrango.entity.ConfiguracaoGoogleDrive;

@Repository
public interface ConfiguracaoGoogleDriveRepository extends JpaRepository<ConfiguracaoGoogleDrive, Long> {

    @Query(value = "SELECT config.* FROM google_drive config "
        + "WHERE  config.funcod=?1 and config.empcod=?2",
        nativeQuery = true)
    ConfiguracaoGoogleDrive consultarConfiguracaoPorFuncionarioEEmpresa(long id, long idEmpresa);

}
