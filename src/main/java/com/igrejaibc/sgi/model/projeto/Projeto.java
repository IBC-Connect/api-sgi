package com.igrejaibc.sgi.model.projeto;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @NotNull
    public String nome;

    @NotNull
    public String descricao;

    @NotNull
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, targetEntity = Programacao.class)
    public List<Programacao> programacao;
}
