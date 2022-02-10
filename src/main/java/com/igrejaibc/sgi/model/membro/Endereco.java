package com.igrejaibc.sgi.model.membro;

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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @NotNull
    public String cep;

    @NotNull
    public String logradouro;

    @NotNull
    public Integer numero;

    @NotNull
    public String complemento;

    @NotNull
    public String bairro;

    @NotNull
    public String cidade;

    @NotNull
    public String estado;
}
