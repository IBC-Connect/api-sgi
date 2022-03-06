package com.igrejaibc.sgi.repository;

import com.igrejaibc.sgi.model.membro.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Usuario, Long> {
    Usuario findByEmail(String email);
}
