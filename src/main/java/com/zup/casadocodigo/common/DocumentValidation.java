package com.zup.casadocodigo.common;

import com.zup.casadocodigo.cliente.modelo.DocumentoTipo;

public abstract class DocumentValidation implements Document{
    @Override
    public abstract DocumentoTipo getTipo();
}
