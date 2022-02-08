package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.model.evento.Evento;
import com.igrejaibc.sgi.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public String cadastrarEventoUseCase(Evento dadosEvento) {
        LOGGER.log(Level.INFO, "Cadastrando Evento...");

        try {
            Evento EventoSalvo = this.eventoService.cadastrarEvento(dadosEvento);
            return "Evento cadastro com sucesso";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public List<Evento> listaEventosUseCase() {
        try {
            return this.eventoService.listarEventos();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Evento EventoPorIdUseCase(String idEvento) {
        try {
            Long id = Long.parseLong(idEvento);
            Optional<Evento> EventoOpcional = this.eventoService.eventoPorId(id);
            return EventoOpcional.isPresent() ? EventoOpcional.get() : Evento.builder().build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void deletarEvento(String idEvento) {
        try {
            Long id = Long.parseLong(idEvento);
            this.eventoService.deletarEvento(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
