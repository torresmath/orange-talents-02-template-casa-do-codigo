package com.zup.casadocodigo.cadastrolivro.controller.dto;

import com.zup.casadocodigo.cadastrocategoria.modelo.Categoria;

public class LivroCategoriaDetalhesResponse {

    private final String nome;

    public LivroCategoriaDetalhesResponse(Categoria categoria) {
        this.nome = categoria.getNome();
    }

    public String getNome() {
        return nome;
    }
}
