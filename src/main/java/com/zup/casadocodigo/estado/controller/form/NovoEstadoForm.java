package com.zup.casadocodigo.estado.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.casadocodigo.estado.modelo.Estado;
import com.zup.casadocodigo.pais.modelo.Pais;
import com.zup.casadocodigo.common.annotations.ExistsId;
import com.zup.casadocodigo.common.annotations.UniqueValues;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;

@UniqueValues(domainClass = Estado.class, fields = {"nome", "idPais"}, aliases = {"nome", "pais.id"}, message = "{estado.unique_nome_pais}")
public class NovoEstadoForm {

    private final String nome;

    @JsonProperty("id_pais")
    @ExistsId(domainClass = Pais.class)
    private final Long idPais;

    public NovoEstadoForm(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager manager) {

        Pais pais = manager.find(Pais.class, idPais);
        Assert.state(pais != null, "Você está tentando criar um Estado com país nulo");

        return new Estado(nome, pais);
    }

    @Deprecated
    public String getNome() {
        return nome;
    }

    @Deprecated
    public Long getIdPais() {
        return idPais;
    }
}
