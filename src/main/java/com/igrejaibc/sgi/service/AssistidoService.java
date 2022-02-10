package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.assistido.Assistido;
import com.igrejaibc.sgi.repository.AssistidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistidoService {

    @Autowired
    public AssistidoRepository assistidoRepository;

    public Assistido cadastrarAssistido(Assistido dadosAssistido) {
        return this.assistidoRepository.save(dadosAssistido);
    }

    public List<Assistido> listarAssistidos(){
        return this.assistidoRepository.findAll();
    }

    public Optional<Assistido> assistidoPorId(Long idAssistido){
        return this.assistidoRepository.findById(idAssistido);
    }

    public void deletarAssistido(Long idAssistido){
        this.assistidoRepository.deleteById(idAssistido);
    }
}
