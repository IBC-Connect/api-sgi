package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.model.assistido.Assistido;
import com.igrejaibc.sgi.service.AssistidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public String cadastrarAssistidoUseCase(Assistido dadosAssistido) {
        LOGGER.log(Level.INFO, "Cadastrando Assistido...");

        try {
            Assistido AssistidoSalvo = this.assistidoService.cadastrarAssistido(dadosAssistido);
            return "Assistido cadastro com sucesso";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public List<Assistido> listaAssistidosUseCase() {
        try {
            return this.assistidoService.listarAssistidos();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Assistido AssistidoPorIdUseCase(String idAssistido) {
        try {
            Long id = Long.parseLong(idAssistido);
            Optional<Assistido> AssistidoOpcional = this.assistidoService.AssistidoPorId(id);
            return AssistidoOpcional.isPresent() ? AssistidoOpcional.get() : Assistido.builder().build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void deletarAssistido(String idAssistido) {
        try {
            Long id = Long.parseLong(idAssistido);
            this.assistidoService.deletarAssistido(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
