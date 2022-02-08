package com.igrejaibc.sgi.service;

import com.igrejaibc.sgi.model.cargo.Cargo;
import com.igrejaibc.sgi.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    public CargoRepository cargoRepository;

    public Cargo cadastrarCargo(Cargo dadosCargo) {
        return this.cargoRepository.save(dadosCargo);
    }

    public List<Cargo> listarCargos(){
        return this.cargoRepository.findAll();
    }

    public Optional<Cargo> CargoPorId(Long idCargo){
        return this.cargoRepository.findById(idCargo);
    }

    public void deletarCargo(Long idCargo){
        this.cargoRepository.deleteById(idCargo);
    }
}
