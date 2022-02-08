package com.igrejaibc.sgi.model.membro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @OneToOne(cascade=CascadeType.PERSIST)
    public InformacoesPessoais infoPessoais;

    @NotNull
    @OneToOne(cascade=CascadeType.PERSIST)
    public InformacoesAcesso infoAcessos;

    @Valid
    @OneToOne(cascade=CascadeType.PERSIST)
    public Endereco endereco;

}
