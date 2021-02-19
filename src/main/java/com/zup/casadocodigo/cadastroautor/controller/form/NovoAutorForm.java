package com.zup.casadocodigo.cadastroautor.controller.form;

import com.zup.casadocodigo.common.UniqueValue;
import com.zup.casadocodigo.cadastroautor.modelo.Autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class NovoAutorForm {

    @NotNull(message = "{_not_null}}")
    @NotEmpty(message = "{_not_blank}")
    private String nome;

    @NotNull(message = "{_not_null}}")
    @NotEmpty(message = "{_not_blank}")
    @Email(message = "{autor.invalid_email}")
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "{autor.duplicated_email}")
    private String email;

    @NotNull(message = "{_not_null}}")
    @NotEmpty(message = "{_not_blank}")
    @Size(max = 400, message = "{autor.descricao_max}")
    private String descricao;

    public Autor toModel() {
        return new Autor(nome, email, descricao);
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
