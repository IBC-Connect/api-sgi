package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.assistido.Assistido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssistidoRepository extends JpaRepository<Assistido, Long> {
}
