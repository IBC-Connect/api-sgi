package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.projeto.Projeto;
import com.igrejaibc.sgi.service.ProjetoService;
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
public class ProjetoUseCase {

    private static final Logger LOGGER = Logger.getLogger(ProjetoUseCase.class.getName());

    @Autowired
    private ProjetoService projetoService;

    public ResponseEntity cadastrarProjetoUseCase(Projeto dadosProjeto) {
        LOGGER.log(Level.INFO, "Cadastrando Projeto...");

        try {
            this.projetoService.cadastrarProjeto(dadosProjeto);
            return ResponseEntity.status(HttpStatus.CREATED).body(Response.builder().message("Projeto Cadastrado com sucesso").build());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity listaProjetosUseCase() {
        try {
            List<Projeto> listaProjeto = this.projetoService.listarProjetos();
            return listaProjeto.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaProjeto);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity projetoPorIdUseCase(String idProjeto) {
        try {
            Long id = Long.parseLong(idProjeto);
            Optional<Projeto> projetoOpcional = this.projetoService.projetoPorId(id);
            return projetoOpcional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(projetoOpcional.get()) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity deletarProjeto(String idProjeto) {
        try {
            Long id = Long.parseLong(idProjeto);
            this.projetoService.deletarProjeto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
