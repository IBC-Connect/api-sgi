package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.model.Membro;
import com.igrejaibc.sgi.service.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public String cadastrarMembroUseCase(Membro dadosMembro) {
        LOGGER.log(Level.INFO, "Cadastrando membro...");

        try {
            Membro membroSalvo = this.membroService.cadastrarMembro(dadosMembro);
            return "Membro cadastro com sucesso";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public List<Membro> listaMembrosUseCase() {
        try {
            return this.membroService.listarMembros();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Membro membroPorIdUseCase(String idMembro) {
        try {
            Long id = Long.parseLong(idMembro);
            Optional<Membro> membroOpcional = this.membroService.membroPorId(id);
            return membroOpcional.isPresent() ? membroOpcional.get() : Membro.builder().build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void deletarMembro(String idMembro) {
        try {
            Long id = Long.parseLong(idMembro);
            this.membroService.deletarMembro(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
