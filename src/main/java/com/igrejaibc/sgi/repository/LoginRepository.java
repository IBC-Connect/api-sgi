package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.membro.InformacoesAcesso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<InformacoesAcesso, Long> {
}
