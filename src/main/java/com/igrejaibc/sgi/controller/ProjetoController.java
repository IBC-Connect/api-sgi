package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.model.projeto.Projeto;
import com.igrejaibc.sgi.response.RequestResponse;
import com.igrejaibc.sgi.usecase.ProjetoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoUseCase projetoUseCase;

    @PostMapping
    public ResponseEntity cadastrarProjeto(@RequestBody @Valid Projeto dadosProjeto) {
        try {
            return this.projetoUseCase.cadastrarProjetoUseCase(dadosProjeto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RequestResponse.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listarProjetos() {
        try {
            return this.projetoUseCase.listaProjetosUseCase();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RequestResponse.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity projetoPorId(@PathVariable("id") String idProjeto) {
        try {
            return this.projetoUseCase.projetoPorIdUseCase(idProjeto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RequestResponse.builder().message(e.getMessage()).build());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarProjeto(@PathVariable("id") String idProjeto) {
        try {
            this.projetoUseCase.deletarProjeto(idProjeto);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(RequestResponse.builder().message(e.getMessage()).build());
        }
    }
}
