package com.zup.casadocodigo.pais.controller;

import com.zup.casadocodigo.pais.controller.dto.PaisDto;
import com.zup.casadocodigo.pais.controller.form.NovoPaisForm;
import com.zup.casadocodigo.pais.modelo.Pais;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public PaisDto cria(@RequestBody @Valid NovoPaisForm paisForm) {

        Pais pais = paisForm.toModel();
        manager.persist(pais);

        return new PaisDto(pais);
    }
}
