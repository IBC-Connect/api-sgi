package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.model.cargo.Cargo;
import com.igrejaibc.sgi.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CargoUseCase {

    private static final Logger LOGGER = Logger.getLogger(CargoUseCase.class.getName());

    @Autowired
    private CargoService cargoService;

    public String cadastrarCargoUseCase(Cargo dadosCargo) {
        LOGGER.log(Level.INFO, "Cadastrando Cargo...");

        try {
            Cargo cargoSalvo = this.cargoService.cadastrarCargo(dadosCargo);
            return "Cargo cadastro com sucesso";
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public List<Cargo> listaCargosUseCase() {
        try {
            return this.cargoService.listarCargos();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Cargo cargoPorIdUseCase(String idCargo) {
        try {
            Long id = Long.parseLong(idCargo);
            Optional<Cargo> CargoOpcional = this.cargoService.CargoPorId(id);
            return CargoOpcional.isPresent() ? CargoOpcional.get() : Cargo.builder().build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public void deletarCargo(String idCargo) {
        try {
            Long id = Long.parseLong(idCargo);
            this.cargoService.deletarCargo(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
