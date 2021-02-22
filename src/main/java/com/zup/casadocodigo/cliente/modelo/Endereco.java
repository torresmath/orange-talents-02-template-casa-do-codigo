package com.zup.casadocodigo.cliente.modelo;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.zup.casadocodigo.estado.modelo.Estado;
import com.zup.casadocodigo.pais.modelo.Pais;
import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String endereco;

    @NotBlank
    private String complemento;

    @NotBlank
    private String cep;

    @NotBlank
    private String cidade;

    @Nullable
    @ManyToOne
    private Estado estado;

    @NotNull
    @ManyToOne
    private Pais pais;

    @NotNull
    @OneToOne
    private Cliente cliente;

    public Endereco(@NotBlank String endereco,
                    @NotBlank String complemento,
                    @NotBlank String cep,
                    @NotBlank String cidade,
                    Estado estado,
                    Pais pais,
                    Cliente cliente) {

        Assert.state(estado != null && estado.pertenceAPais(pais), "Estado não pertence ao país informado");

        this.endereco = endereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.cliente = cliente;
    }
}
