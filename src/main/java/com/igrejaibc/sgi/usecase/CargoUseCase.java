package com.igrejaibc.sgi.usecase;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.cargo.Cargo;
import com.igrejaibc.sgi.service.CargoService;
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
public class CargoUseCase {

    private static final Logger LOGGER = Logger.getLogger(CargoUseCase.class.getName());

    @Autowired
    private CargoService cargoService;

    public ResponseEntity cadastrarCargoUseCase(Cargo dadosCargo) {
        LOGGER.log(Level.INFO, "Cadastrando Cargo...");

        try {
            this.cargoService.cadastrarCargo(dadosCargo);
            return ResponseEntity.status(HttpStatus.OK).body(Response.builder().message("Cargo Cadastrado com Sucesso.").build());
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Já existe um usuario com o mesmo cpf ou e-mail cadastrado", e);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity listaCargosUseCase() {
        try {
            List<Cargo> listaCargos = this.cargoService.listarCargos();
            return listaCargos.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).build() : ResponseEntity.status(HttpStatus.OK).body(listaCargos);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity cargoPorIdUseCase(String idCargo) {
        try {
            Long id = Long.parseLong(idCargo);
            Optional<Cargo> CargoOpcional = this.cargoService.cargoPorId(id);
            return CargoOpcional.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(CargoOpcional.get()) : ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public ResponseEntity deletarCargo(String idCargo) {
        try {
            Long id = Long.parseLong(idCargo);
            this.cargoService.deletarCargo(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
