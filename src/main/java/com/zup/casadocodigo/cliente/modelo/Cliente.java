package com.zup.casadocodigo.cliente.modelo;

import com.zup.casadocodigo.common.annotations.CPForCNPJ;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    private String email;

    @NotBlank
    @CPForCNPJ
    private String documento;

    public Cliente(@NotBlank String nome, @NotBlank String sobrenome, @NotBlank String email, @NotBlank String documento) {

        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento.replaceAll("[.-]", "");
    }

    public Long getId() {
        return id;
    }
}
