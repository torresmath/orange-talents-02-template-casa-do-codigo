package com.zup.casadocodigo.cliente.controller.form;

import com.zup.casadocodigo.cliente.modelo.Cliente;
import com.zup.casadocodigo.common.UniqueValue;

import javax.persistence.EntityManager;
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

    private final List<ClienteDetalhes> detalhes;

    @Valid
    @NotNull(message = "{_not_null}")
    private final NovoEnderecoForm endereco;

    @Valid
    @NotNull(message = "{_not_null}")
    private final NovoTelefoneForm telefone;

    @Valid
    @NotNull(message = "{_not_null}")
    private final NovoDocumentoForm documento;

    @Valid
    public NovoClienteForm(@NotBlank(message = "{_not_blank}") String nome,
                           @NotBlank(message = "{_not_blank}") String sobrenome,
                           @NotBlank(message = "{_not_blank}") String email,
                           @Valid @NotNull NovoEnderecoForm endereco,
                           @Valid @NotNull NovoTelefoneForm telefone,
                           @Valid @NotNull NovoDocumentoForm documento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.documento = documento;

        this.detalhes = Arrays.asList(endereco, telefone, documento);
    }

    public Cliente toModel(EntityManager manager) {

        Cliente cliente = new Cliente(nome, sobrenome, email);
        detalhes.forEach(detalhe -> detalhe.mapCliente(cliente, manager));
        return cliente;
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

    public NovoDocumentoForm getDocumento() {
        return documento;
    }
}
