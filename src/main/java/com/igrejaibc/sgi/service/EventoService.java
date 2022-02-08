package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.evento.Evento;
import com.igrejaibc.sgi.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    public EventoRepository eventoRepository;

    public Evento cadastrarEvento(Evento dadosEvento) {
        return this.eventoRepository.save(dadosEvento);
    }

    public List<Evento> listarEventos(){
        return this.eventoRepository.findAll();
    }

    public Optional<Evento> eventoPorId(Long idEvento){
        return this.eventoRepository.findById(idEvento);
    }

    public void deletarEvento(Long idEvento){
        this.eventoRepository.deleteById(idEvento);
    }
}
