package com.zup.casadocodigo.pais.controller.dto;

import com.zup.casadocodigo.pais.modelo.Pais;

public class PaisDto {

    private final Long id;
    private final String nome;


    public PaisDto(Pais pais) {
        this.id = pais.getId();
        this.nome = pais.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
