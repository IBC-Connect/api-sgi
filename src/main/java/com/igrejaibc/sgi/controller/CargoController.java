package com.igrejaibc.sgi.controller;

import com.igrejaibc.sgi.http.Response;
import com.igrejaibc.sgi.model.cargo.Cargo;
import com.igrejaibc.sgi.usecase.CargoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/cargo")
public class CargoController {

    @Autowired
    private CargoUseCase cargoUseCase;

    @PostMapping
    public ResponseEntity cadastrarCargo(@RequestBody @Valid Cargo dadosCargo) {
        try {
            return this.cargoUseCase.cadastrarCargoUseCase(dadosCargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping
    public ResponseEntity listarCargos() {
        try {
            return this.cargoUseCase.listaCargosUseCase();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity cargoPorId(@PathVariable("id") String idCargo) {
        try {
            return this.cargoUseCase.cargoPorIdUseCase(idCargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity deletarCargo(@PathVariable("id") String idCargo) {
        try {
            this.cargoUseCase.deletarCargo(idCargo);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().message(e.getMessage()).build());
        }
    }
}
