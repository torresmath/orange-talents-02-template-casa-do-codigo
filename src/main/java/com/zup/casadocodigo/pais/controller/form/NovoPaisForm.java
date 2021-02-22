package com.zup.casadocodigo.pais.controller.form;

import com.zup.casadocodigo.pais.modelo.Pais;
import com.zup.casadocodigo.common.annotations.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoPaisForm {

    @NotNull(message = "{_not_null}}")
    @NotBlank(message = "{_not_blank}")
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "{pais.unique_nome}")
    private String nome;

    public Pais toModel() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
