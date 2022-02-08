package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.membro.Membro;
import com.igrejaibc.sgi.repository.MembroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    @Autowired
    public MembroRepository membroRepository;

    public Membro cadastrarMembro(Membro dadosMembro) {
        return this.membroRepository.save(dadosMembro);
    }

    public List<Membro> listarMembros(){
        return this.membroRepository.findAll();
    }

    public Optional<Membro> membroPorId(Long idMembro){
        return this.membroRepository.findById(idMembro);
    }

    public void deletarMembro(Long idMembro){
        this.membroRepository.deleteById(idMembro);
    }
}
