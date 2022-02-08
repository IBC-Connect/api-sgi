package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.model.membro.Membro;
import com.igrejaibc.sgi.response.RequestResponse;
import com.igrejaibc.sgi.service.MembroService;
import jdk.nashorn.internal.ir.ReturnNode;
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
public class MembroUseCase {

    private static final Logger LOGGER = Logger.getLogger(MembroUseCase.class.getName());

    @Autowired
    private MembroService membroService;

    public ResponseEntity cadastrarMembroUseCase(Membro dadosMembro) {
        LOGGER.log(Level.INFO, "Cadastrando membro...");

        try {
            this.membroService.cadastrarMembro(dadosMembro);
            return ResponseEntity.status(HttpStatus.OK).body(RequestResponse.builder().message("Membro Cadastrado com Sucesso."));
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity listaMembrosUseCase() {
        try {
            List<Membro> listaMembros = this.membroService.listarMembros();
            return listaMembros.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaMembros);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity membroPorIdUseCase(String idMembro) {
        try {
            Long id = Long.parseLong(idMembro);
            Optional<Membro> membroOpcional = this.membroService.membroPorId(id);
            return membroOpcional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(membroOpcional.get()) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity deletarMembro(String idMembro) {
        try {
            Long id = Long.parseLong(idMembro);
            this.membroService.deletarMembro(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
