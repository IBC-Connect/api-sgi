package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.projeto.Projeto;
import com.igrejaibc.sgi.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    public ProjetoRepository projetoRepository;

    public Projeto cadastrarProjeto(Projeto dadosProjeto) {
        return this.projetoRepository.save(dadosProjeto);
    }

    public List<Projeto> listarProjetos(){
        return this.projetoRepository.findAll();
    }

    public Optional<Projeto> projetoPorId(Long idProjeto){
        return this.projetoRepository.findById(idProjeto);
    }

    public void deletarProjeto(Long idProjeto){
        this.projetoRepository.deleteById(idProjeto);
    }
}
