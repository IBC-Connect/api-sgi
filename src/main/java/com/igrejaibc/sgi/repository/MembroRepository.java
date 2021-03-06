package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.membro.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}
