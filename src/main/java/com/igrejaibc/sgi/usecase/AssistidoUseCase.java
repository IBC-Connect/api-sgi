package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.assistido.Assistido;
import com.igrejaibc.sgi.service.AssistidoService;
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
public class AssistidoUseCase {

    private static final Logger LOGGER = Logger.getLogger(AssistidoUseCase.class.getName());

    @Autowired
    private AssistidoService assistidoService;

    public ResponseEntity cadastrarAssistidoUseCase(Assistido dadosAssistido) {
        LOGGER.log(Level.INFO, "Cadastrando Assistido...");

        try {
            this.assistidoService.cadastrarAssistido(dadosAssistido);
            return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Assistido Cadastrado com Sucesso.").build());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity listaAssistidosUseCase() {
        try {
            List<Assistido> listaAssistidos = this.assistidoService.listarAssistidos();
            return listaAssistidos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaAssistidos);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity assistidoPorIdUseCase(String idAssistido) {
        try {
            Long id = Long.parseLong(idAssistido);
            Optional<Assistido> AssistidoOpcional = this.assistidoService.assistidoPorId(id);
            return AssistidoOpcional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(AssistidoOpcional.get()) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity deletarAssistido(String idAssistido) {
        try {
            Long id = Long.parseLong(idAssistido);
            this.assistidoService.deletarAssistido(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
