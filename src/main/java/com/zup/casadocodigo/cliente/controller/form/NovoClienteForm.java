package com.zup.casadocodigo.cliente.controller.form;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zup.casadocodigo.cliente.modelo.Cliente;
import com.zup.casadocodigo.common.annotations.CPForCNPJ;
import com.zup.casadocodigo.common.annotations.UniqueValue;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

public class NovoClienteForm {

    @NotBlank(message = "{_not_blank}")
    private final String nome;

    @NotBlank(message = "{_not_blank}")
    private final String sobrenome;

    @NotBlank(message = "{_not_blank}")
    @Email(message = "{_invalid_email}")
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private final String email;

    @Valid
    @NotNull(message = "{_not_null}")
    @CPForCNPJ
    @UniqueValue(domainClass = Cliente.class, fieldName = "documento", enableRegex = true, regex = "[.-]")
    private final String documento;

    @Valid
    @NotNull(message = "{_not_null}")
    private final NovoEnderecoForm endereco;

    @Valid
    @NotNull(message = "{_not_null}")
    private final NovoTelefoneForm telefone;

    @JsonIgnore
    private final List<ClienteDetalhes> detalhes;

    @Valid
    public NovoClienteForm(@NotBlank(message = "{_not_blank}") String nome,
                           @NotBlank(message = "{_not_blank}") String sobrenome,
                           @NotBlank(message = "{_not_blank}") String email,
                           @NotBlank(message = "{_not_blank}") String documento,
                           @Valid @NotNull NovoEnderecoForm endereco,
                           @Valid @NotNull NovoTelefoneForm telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.documento = documento;

        this.detalhes = Arrays.asList(endereco, telefone);
    }

    public Cliente toModel() {
        return new Cliente(nome, sobrenome, email, documento);
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public NovoEnderecoForm getEndereco() {
        return endereco;
    }

    public NovoTelefoneForm getTelefone() {
        return telefone;
    }

    public @Valid @NotNull(message = "{_not_null}") String getDocumento() {
        return documento;
    }

    public List<ClienteDetalhes> getDetalhes() {
        return detalhes;
    }

    @JsonIgnore
    public Long getIdPais() {
        return endereco.getIdPais();
    }
    @JsonIgnore
    public Long getIdEstado() {
        return endereco.getIdEstado();
    }

}
