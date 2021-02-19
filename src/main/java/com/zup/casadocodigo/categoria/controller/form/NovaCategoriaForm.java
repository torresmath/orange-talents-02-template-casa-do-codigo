package com.zup.casadocodigo.categoria.controller.form;

import com.zup.casadocodigo.common.UniqueValue;
import com.zup.casadocodigo.categoria.modelo.Categoria;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovaCategoriaForm {

    @NotNull(message = "{_not_null}}")
    @NotBlank(message = "{___not_blank}")
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "{categoria.duplicated_nome}")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(nome);
    }
}
