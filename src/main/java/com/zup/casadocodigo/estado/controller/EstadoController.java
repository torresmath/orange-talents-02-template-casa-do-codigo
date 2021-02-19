package com.zup.casadocodigo.estado.controller;

import com.zup.casadocodigo.estado.controller.dto.EstadoDto;
import com.zup.casadocodigo.estado.controller.form.NovoEstadoForm;
import com.zup.casadocodigo.estado.modelo.Estado;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public EstadoDto cria(@RequestBody @Valid NovoEstadoForm estadoForm) {

        Estado estado = estadoForm.toModel(manager);
        manager.persist(estado);
        return new EstadoDto(estado);
    }
}
