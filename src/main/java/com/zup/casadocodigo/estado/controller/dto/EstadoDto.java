package com.zup.casadocodigo.estado.controller.dto;

import com.zup.casadocodigo.estado.modelo.Estado;
import com.zup.casadocodigo.pais.controller.dto.PaisDto;

public class EstadoDto {

    private final Long id;
    private final String nome;
    private final PaisDto pais;

    public EstadoDto(Estado estado) {
        this.id = estado.getId();
        this.nome = estado.getNome();
        this.pais = new PaisDto(estado.getPais());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public PaisDto getPais() {
        return pais;
    }
}
