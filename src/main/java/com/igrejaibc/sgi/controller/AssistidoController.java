package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.assistido.Assistido;
import com.igrejaibc.sgi.usecase.AssistidoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/assistido")
public class AssistidoController {

    @Autowired
    private AssistidoUseCase assistidoUseCase;

    @PostMapping
    public ResponseEntity cadastrarAssistido(@RequestBody @Valid Assistido dadosAssistido) {
        try {
            return this.assistidoUseCase.cadastrarAssistidoUseCase(dadosAssistido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listarAssistidos() {
        try {
            return this.assistidoUseCase.listaAssistidosUseCase();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity assistidoPorId(@PathVariable("id") String idAssistido) {
        try {
            return this.assistidoUseCase.assistidoPorIdUseCase(idAssistido);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarAssistido(@PathVariable("id") String idAssistido) {
        try {
            this.assistidoUseCase.deletarAssistido(idAssistido);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
