package com.igrejaibc.sgi.model.membro;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String perfil;

    @NotNull
    @Email(message = "E-mail inválido")
    @Column(unique = true)
    private String email;

    @NotNull
    private String senha;
}
