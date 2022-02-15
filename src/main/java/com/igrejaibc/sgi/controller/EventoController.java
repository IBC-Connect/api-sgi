package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.evento.Evento;
import com.igrejaibc.sgi.usecase.EventoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/evento")
public class EventoController {

    @Autowired
    private EventoUseCase eventoUseCase;

    @PostMapping
    public ResponseEntity cadastrarEvento(@RequestBody @Valid Evento dadosEvento) {
        try {
            return this.eventoUseCase.cadastrarEventoUseCase(dadosEvento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listarEventos() {
        try {
            return this.eventoUseCase.listaEventosUseCase();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity eventoPorId(@PathVariable("id") String idEvento) {
        try {
            return this.eventoUseCase.eventoPorIdUseCase(idEvento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarEvento(@PathVariable("id") String idEvento) {
        try {
            this.eventoUseCase.deletarEvento(idEvento);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
