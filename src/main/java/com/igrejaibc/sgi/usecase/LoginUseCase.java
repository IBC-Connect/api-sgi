package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.mapper.LoginMapper;
import com.igrejaibc.sgi.model.membro.InformacoesAcesso;
import com.igrejaibc.sgi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LoginUseCase {

    private static final Logger LOGGER = Logger.getLogger(CargoUseCase.class.getName());

    @Autowired
    private LoginService loginService;

    public ResponseEntity login(InformacoesAcesso dadosLogin) {
        LOGGER.log(Level.INFO, "Verificando dados login...");

        try {
            List<InformacoesAcesso> infoAcessos = this.loginService.listaUsuarios();
            Optional<InformacoesAcesso> loginRealizado = infoAcessos.stream().filter(c -> c.getLogin().equals(dadosLogin.getLogin()) && c.getSenha().equals(dadosLogin.getSenha())).findFirst();
            return loginRealizado.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(LoginMapper.builder().loginRealizado(true).message("Login realizado com sucesso").build()) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(LoginMapper.builder().loginRealizado(false).message("Dados incorretos/inválidos para realizar o login").build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
