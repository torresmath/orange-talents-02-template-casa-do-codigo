package com.zup.casadocodigo.cliente.controller.form;

import com.zup.casadocodigo.cliente.modelo.Cliente;

import javax.persistence.EntityManager;

public interface ClienteDetalhes<T> {

    T mapCliente(Cliente cliente, EntityManager manager);
}
