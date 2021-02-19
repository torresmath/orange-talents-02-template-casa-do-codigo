package com.zup.casadocodigo.cliente.controller;

import com.zup.casadocodigo.cliente.controller.form.NovoClienteForm;
import com.zup.casadocodigo.cliente.modelo.Cliente;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @InitBinder
    public void init(WebDataBinder binder) {

    }

    @PostMapping
    @Transactional
    public String cria(@RequestBody @Valid NovoClienteForm clienteForm) {

        Cliente cliente = clienteForm.toModel(manager);
        manager.persist(cliente);
        return "OK";

    }
}
