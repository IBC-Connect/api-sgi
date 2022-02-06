package com.igrejaibc.sgi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class InformacoesPessoais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String nomeCompleto;

    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate dataNascimento;

    @Column(unique=true)
    public String cpf;

    public String rg;
    public String telefone;
    public String whatsapp;

    @Column(unique=true)
    public String email;

    public String estadoCivil;
    public String escolaridade;
    public boolean trabalhandoAtualmente;
    public String profissao;

    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate dataBastismo;

    @JsonFormat(pattern="dd/MM/yyyy")
    public LocalDate membroDesde;
}
