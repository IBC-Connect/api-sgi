package com.igrejaibc.sgi.model.membro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class InformacoesPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String nomeCompleto;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(unique = true)
    private String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String rg;

    @NonNull
    private String telefone;

    @NonNull
    private String whatsapp;

    @Column(unique = true)
    private String email;

    @NonNull
    private String estadoCivil;

    @NonNull
    private String escolaridade;

    @NonNull
    private boolean trabalhandoAtualmente;

    @NonNull
    private String profissao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataBastismo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate membroDesde;
}
