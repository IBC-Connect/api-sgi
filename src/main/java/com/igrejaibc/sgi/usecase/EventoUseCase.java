package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.evento.Evento;
import com.igrejaibc.sgi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class EventoUseCase {

    private static final Logger LOGGER = Logger.getLogger(EventoUseCase.class.getName());

    @Autowired
    private EventoService eventoService;

    public ResponseEntity cadastrarEventoUseCase(Evento dadosEvento) {
        LOGGER.log(Level.INFO, "Cadastrando Evento...");

        try {
            this.eventoService.cadastrarEvento(dadosEvento);
            LOGGER.log(Level.INFO, "Evento cadastrado...");
            return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder().message("Evento Cadastrado com Sucesso.").build());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    public ResponseEntity listaEventosUseCase() {
        try {
            List<Evento> listaEventos = this.eventoService.listarEventos();
            return listaEventos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaEventos);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity eventoPorIdUseCase(String idEvento) {
        try {
            Long id = Long.parseLong(idEvento);
            Optional<Evento> EventoOpcional = this.eventoService.eventoPorId(id);
            return EventoOpcional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(EventoOpcional.get()) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity deletarEvento(String idEvento) {
        try {
            Long id = Long.parseLong(idEvento);
            this.eventoService.deletarEvento(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
