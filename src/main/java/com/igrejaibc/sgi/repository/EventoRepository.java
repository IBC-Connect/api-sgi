package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {
}
