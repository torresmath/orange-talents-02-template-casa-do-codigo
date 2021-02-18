package com.zup.casadocodigo.cadastroestado.modelo;

import com.zup.casadocodigo.cadastropais.modelo.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {
        "nome",
        "pais_id"
}))
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @ManyToOne
    private Pais pais;

    public Estado(@NotNull @NotBlank String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado() {}
}
