package com.zup.casadocodigo.cliente.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.casadocodigo.cliente.modelo.Cliente;
import com.zup.casadocodigo.cliente.modelo.Endereco;
import com.zup.casadocodigo.estado.modelo.Estado;
import com.zup.casadocodigo.pais.modelo.Pais;
import com.zup.casadocodigo.common.ExistsId;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoEnderecoForm implements ClienteDetalhes<Endereco> {

    @NotNull(message = "{_not_null}")
    @NotBlank(message = "{_not_blank}")
    private final String endereco;

    @NotNull(message = "{_not_null}")
    @NotBlank(message = "{_not_blank}")
    private final String complemento;

    @NotNull(message = "{_not_null}")
    @NotBlank(message = "{_not_blank}")
    private final String cep;

    @NotNull(message = "{_not_null}")
    @NotBlank(message = "{_not_blank}")
    private final String cidade;

    @NotNull(message = "{_not_null}")
    @JsonProperty("id_pais")
    @ExistsId(domainClass = Pais.class)
    private final Long idPais;

    @NotNull(message = "{_not_null}")
    @JsonProperty("id_estado")
    private final Long idEstado;

    public NovoEnderecoForm(@NotBlank(message = "{_not_blank}") String endereco,
                            @NotBlank(message = "{_not_blank}") String complemento,
                            @NotBlank(message = "{_not_blank}") String cep,
                            @NotBlank(message = "{_not_blank}") String cidade,
                            @NotNull(message = "{_not_null}") Long idPais,
                            @NotNull(message = "{_not_null}") Long idEstado) {

        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    @Override
    public Endereco mapCliente(Cliente cliente, EntityManager manager) {
        Pais pais = manager.find(Pais.class, idPais);
        Estado estado = manager.find(Estado.class, idEstado);
        Endereco endereco = new Endereco(this.endereco, this.complemento, this.cep, this.cidade, estado, pais, cliente);
        manager.persist(endereco);
        return endereco;
    }
}
