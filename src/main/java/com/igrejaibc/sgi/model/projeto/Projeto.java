package com.igrejaibc.sgi.model.projeto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String descricao;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Programacao.class, orphanRemoval = true)
    private List<Programacao> programacao;
}
