package com.zup.casadocodigo.autor.controller.dto;

import com.zup.casadocodigo.autor.modelo.Autor;

public class AutorDto {

    private final Long id;

    private final String nome;

    private final String email;

    private final String descricao;

    public AutorDto(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.email = autor.getEmail();
        this.descricao = autor.getDescricao();
    }

    @Override
    public String toString() {
        return "AutorDto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }
}
