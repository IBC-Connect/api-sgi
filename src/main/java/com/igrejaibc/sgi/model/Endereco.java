package com.igrejaibc.sgi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public String cep;
    public String logradouro;
    public Integer numero;
    public String complemento;
    public String bairro;
    public String cidade;
    public String estado;
}
