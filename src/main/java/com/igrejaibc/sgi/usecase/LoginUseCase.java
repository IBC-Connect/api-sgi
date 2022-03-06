package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.mapper.LoginMapper;
import com.igrejaibc.sgi.model.membro.Usuario;
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

    public ResponseEntity login(Usuario dadosLogin) {
        LOGGER.log(Level.INFO, "Verificando dados login...");

        try {
            List<Usuario> infoAcessos = this.loginService.listaUsuarios();
            Optional<Usuario> loginRealizado = infoAcessos.stream().filter(c -> c.getEmail().equals(dadosLogin.getEmail()) && c.getSenha().equals(dadosLogin.getSenha())).findFirst();
            return loginRealizado.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(LoginMapper.builder().message("Login realizado com sucesso").build()) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(LoginMapper.builder().message("Dados incorretos/inválidos para realizar o login").build());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity buscarDadosUsuario(String email) {
        LOGGER.log(Level.INFO, "Verificando dados usuario...");

        try {
            Usuario loginRealizado = this.loginService.dadosUsuario(email);
            return ResponseEntity.status(HttpStatus.OK).body(loginRealizado);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
