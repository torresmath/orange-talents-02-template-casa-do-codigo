package com.zup.casadocodigo.cliente.controller.form;

import com.zup.casadocodigo.cliente.modelo.Cliente;
import com.zup.casadocodigo.cliente.modelo.Documento;
import com.zup.casadocodigo.cliente.modelo.DocumentoTipo;
import com.zup.casadocodigo.common.CPForCNPJ;
import com.zup.casadocodigo.common.CnpjGroup;
import com.zup.casadocodigo.common.CpfGroup;
import com.zup.casadocodigo.common.Document;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class NovoDocumentoForm implements ClienteDetalhes<Documento> {

    // todo validar enum
    @NotNull(message = "{_not_null}")

    private DocumentoTipo tipo;
    @NotBlank(message = "{_not_blank}")

    @CPForCNPJ
    private String documento;

    private Cliente cliente;

    public NovoDocumentoForm(@NotBlank(message = "{_not_blank}") DocumentoTipo tipo,
                             @NotBlank(message = "{_not_blank}") String documento) {
        this.tipo = tipo;
        this.documento = documento;
    }

    public DocumentoTipo getTipo() {
        return tipo;
    }

    public String getDocumento() {
        return documento;
    }

    @Override
    public Documento mapCliente(Cliente cliente, EntityManager manager) {
        this.cliente = cliente;
        Documento documento = new Documento(tipo, this.documento, cliente);
        manager.persist(documento);
        return documento;
    }
}
