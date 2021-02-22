package com.zup.casadocodigo.cliente.controller;

import com.zup.casadocodigo.cliente.controller.form.NovoClienteForm;
import com.zup.casadocodigo.cliente.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    private EstadoPertenceAPaisValidator estadoPertenceAPaisValidator;


    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(estadoPertenceAPaisValidator);
    }

    @PostMapping
    @Transactional
    public Map<String, Long> cria(@RequestBody @Valid NovoClienteForm clienteForm) {

        Cliente cliente = clienteForm.toModel();
        clienteForm.getDetalhes().forEach(detalhe -> detalhe.mapCliente(cliente, manager));
        manager.persist(cliente);

        HashMap<String, Long> response = new HashMap<>(1);
        response.put("id", cliente.getId());

        return response;

    }
}
