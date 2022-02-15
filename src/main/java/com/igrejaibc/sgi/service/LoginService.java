package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.assistido.Assistido;
import com.igrejaibc.sgi.model.membro.InformacoesAcesso;
import com.igrejaibc.sgi.repository.AssistidoRepository;
import com.igrejaibc.sgi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    public LoginRepository loginRepository;

    public List<InformacoesAcesso> listaUsuarios() {
        return this.loginRepository.findAll();
    }
}
