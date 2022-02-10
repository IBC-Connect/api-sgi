package com.igrejaibc.sgi.model.membro;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class InformacoesAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String perfilAcesso;
    public String login;
    public String senha;
}
