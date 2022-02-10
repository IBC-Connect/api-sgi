package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.model.membro.Membro;
import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.usecase.MembroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/membro")
public class MembroController {

    @Autowired
    private MembroUseCase membroUseCase;

    @PostMapping
    public ResponseEntity cadastrarMembro(@RequestBody @Valid Membro dadosMembro){
        try{
            return this.membroUseCase.cadastrarMembroUseCase(dadosMembro);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity listarMembros(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.membroUseCase.listaMembrosUseCase());
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity membroPorId(@PathVariable("id") String idMembro){
        try{
            return this.membroUseCase.membroPorIdUseCase(idMembro);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()));
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarMembro(@PathVariable("id") String idMembro){
        try{
            return this.membroUseCase.deletarMembro(idMembro);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()));
        }
    }
}
