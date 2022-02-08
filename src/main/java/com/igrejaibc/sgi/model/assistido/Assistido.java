package com.igrejaibc.sgi.model.assistido;

import com.igrejaibc.sgi.model.membro.Endereco;
import com.igrejaibc.sgi.model.membro.InformacoesPessoais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Assistido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    public InformacoesPessoais infoPessoais;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    public Endereco endereco;
}
