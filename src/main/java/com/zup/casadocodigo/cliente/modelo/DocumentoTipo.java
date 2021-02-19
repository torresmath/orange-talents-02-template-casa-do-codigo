package com.zup.casadocodigo.cliente.modelo;

import com.zup.casadocodigo.common.CnpjGroup;
import com.zup.casadocodigo.common.CpfGroup;

public enum DocumentoTipo {
    CPF(CpfGroup.class),
    CNPJ(CnpjGroup.class);

    private final Class<?> group;

    DocumentoTipo(Class<?> group) {
        this.group = group;
    }

    public Class<?> getGroup() {
        return group;
    }
}
