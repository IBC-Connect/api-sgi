package com.igrejaibc.sgi.model.evento;

import com.igrejaibc.sgi.model.membro.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private LocalDate data;

    @NotNull
    private String horarioInicial;

    @NotNull
    private String horarioFinal;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST)
    private Endereco endereco;

}
