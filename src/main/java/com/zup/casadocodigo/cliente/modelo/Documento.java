package com.zup.casadocodigo.cliente.modelo;

import com.zup.casadocodigo.common.CPForCNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cliente_documento")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DocumentoTipo tipo;

    @NotBlank
    @CPForCNPJ
    private String documento;

    @NotNull
    @OneToOne
    private Cliente cliente;

    public Documento(DocumentoTipo tipo, @NotBlank String documento, Cliente cliente) {
        this.tipo = tipo;
        this.documento = documento;
        this.cliente = cliente;
    }

    public DocumentoTipo getTipo() {
        return tipo;
    }
}
