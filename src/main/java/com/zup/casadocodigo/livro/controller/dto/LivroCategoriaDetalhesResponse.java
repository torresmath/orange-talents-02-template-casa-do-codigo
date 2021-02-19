package com.zup.casadocodigo.livro.controller.dto;

import com.zup.casadocodigo.categoria.modelo.Categoria;

public class LivroCategoriaDetalhesResponse {

    private final String nome;

    public LivroCategoriaDetalhesResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
