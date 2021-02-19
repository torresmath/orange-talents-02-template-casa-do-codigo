package com.zup.casadocodigo.cliente.modelo;

import com.sun.istack.NotNull;
import com.zup.casadocodigo.cliente.controller.form.DocumentSequenceProvider;
import com.zup.casadocodigo.common.CnpjGroup;
import com.zup.casadocodigo.common.CpfGroup;
import com.zup.casadocodigo.common.Document;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "cliente_documento")
@GroupSequenceProvider(DocumentSequenceProvider.class)
public class Documento implements Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @CPF(groups = CpfGroup.class, message = "Precisa ser CPF")
    @CNPJ(groups = CnpjGroup.class, message = "Precisa ser CNPJ")
    private DocumentoTipo tipo;

    @NotBlank
    private String documento;

    @NotNull
    @OneToOne
    private Cliente cliente;

    public Documento(DocumentoTipo tipo, @NotBlank String documento, Cliente cliente) {
        this.tipo = tipo;
        this.documento = documento;
        this.cliente = cliente;
    }

    @Override
    public DocumentoTipo getTipo() {
        return tipo;
    }
}
