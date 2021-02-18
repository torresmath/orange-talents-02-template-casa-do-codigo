package com.zup.casadocodigo.cadastropais.controller.form;

import com.zup.casadocodigo.cadastropais.modelo.Pais;
import com.zup.casadocodigo.common.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoPaisForm {

    @NotNull(message = "{not_null}")
    @NotBlank(message = "{not_blank}")
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "Já existe um país com o nome fornecido")
    private String nome;

    public Pais toModel() {
        return new Pais(nome);
    }

    public String getNome() {
        return nome;
    }
}
