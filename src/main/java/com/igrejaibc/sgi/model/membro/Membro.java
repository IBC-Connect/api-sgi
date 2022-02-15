package com.igrejaibc.sgi.model.membro;

import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Membro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne(cascade=CascadeType.PERSIST, orphanRemoval = true)
    private InformacoesPessoais infoPessoais;

    @NotNull
    @OneToOne(cascade=CascadeType.PERSIST, orphanRemoval = true)
    private InformacoesAcesso infoAcessos;

    @Valid
    @OneToOne(cascade=CascadeType.PERSIST, orphanRemoval = true)
    private Endereco endereco;

}
