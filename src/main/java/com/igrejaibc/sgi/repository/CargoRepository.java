package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.cargo.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
