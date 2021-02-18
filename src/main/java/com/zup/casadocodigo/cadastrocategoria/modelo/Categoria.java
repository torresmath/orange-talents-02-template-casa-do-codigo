package com.zup.casadocodigo.cadastrocategoria.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    @Deprecated
    public Categoria() {
    }

    public Categoria(Long idCategoria) {
        this.id = idCategoria;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
