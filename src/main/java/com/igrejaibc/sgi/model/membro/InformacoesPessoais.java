package com.igrejaibc.sgi.model.membro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    public Long id;

    public String nomeCompleto;

    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate dataNascimento;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Column(unique=true)
    public String cpf;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String rg;

    public String telefone;
    public String whatsapp;

    @Column(unique=true)
    public String email;

    public String estadoCivil;
    public String escolaridade;
    public boolean trabalhandoAtualmente;
    public String profissao;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate dataBastismo;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate membroDesde;
}
