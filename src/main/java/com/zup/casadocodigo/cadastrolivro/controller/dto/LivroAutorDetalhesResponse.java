package com.zup.casadocodigo.cadastrolivro.controller.dto;

import com.zup.casadocodigo.cadastroautor.modelo.Autor;

public class LivroAutorDetalhesResponse {

    private final String nome;
    private final String descricao;

    public LivroAutorDetalhesResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
