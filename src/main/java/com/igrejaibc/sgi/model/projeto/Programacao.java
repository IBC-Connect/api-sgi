package com.igrejaibc.sgi.model.projeto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Programacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("dia")
    @NotNull
    private String dia;

    @JsonProperty("horarioInicial")
    @NotNull
    private String horarioInicial;

    @JsonProperty("horarioFinal")
    @NotNull
    private String horarioFinal;
}
