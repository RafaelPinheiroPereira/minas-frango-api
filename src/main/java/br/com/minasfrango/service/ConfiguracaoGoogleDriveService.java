package br.com.minasfrango.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.minasfrango.entity.ConfiguracaoGoogleDrive;
import br.com.minasfrango.repository.ConfiguracaoGoogleDriveRepository;

@Service
public class ConfiguracaoGoogleDriveService {

    @Autowired
    ConfiguracaoGoogleDriveRepository configuracaoGoogleDriveRepository;

    public ConfiguracaoGoogleDrive conultarConfiguracaoDoFuncionario(long id, long idEmpresa) {
        // TODO Auto-generated method stub
        return configuracaoGoogleDriveRepository.consultarConfiguracaoPorFuncionarioEEmpresa(id, idEmpresa);
    }

    public void salvarConfiguracao(ConfiguracaoGoogleDrive configuracaoGoogleDrive) {
        configuracaoGoogleDriveRepository.save(configuracaoGoogleDrive);

    }

}
