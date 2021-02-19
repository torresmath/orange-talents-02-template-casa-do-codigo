package com.zup.casadocodigo.cliente.controller.form;

import com.zup.casadocodigo.cliente.modelo.Cliente;
import com.zup.casadocodigo.cliente.modelo.Telefone;

import javax.persistence.EntityManager;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class NovoTelefoneForm implements ClienteDetalhes<Telefone> {

    // @todo Anotação FixedSize
    @NotNull(message = "{_not_null}")
    @Digits(integer = 2, fraction = 0)
    private final int ddd;

    // @todo Anotação Between
    @NotNull(message = "{_not_null}")
    private final int numero;

    public NovoTelefoneForm(@NotNull(message = "{_not_null}") int ddd, @NotNull(message = "{_not_null}") int numero) {
        this.ddd = ddd;
        this.numero = numero;
    }

    public int getDdd() {
        return ddd;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public Telefone mapCliente(Cliente cliente, EntityManager manager) {
        Telefone telefone = new Telefone(this.ddd, this.numero, cliente);
        manager.persist(telefone);
        return telefone;
    }
}
