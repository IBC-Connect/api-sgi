package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.membro.Usuario;
import com.igrejaibc.sgi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    public LoginRepository loginRepository;

    public List<Usuario> listaUsuarios() {
        return this.loginRepository.findAll();
    }

    public Usuario dadosUsuario(String email) {
        return this.loginRepository.findByEmail(email);
    }
}
