package com.igrejaibc.sgi.model.evento;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igrejaibc.sgi.model.membro.Endereco;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate data;

    @NotNull
    private String horarioInicial;

    @NotNull
    private String horarioFinal;

    @NotNull
    @OneToOne(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private Endereco endereco;

}
