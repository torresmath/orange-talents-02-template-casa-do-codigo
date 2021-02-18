package com.zup.casadocodigo.cadastroautor.controller;

import com.zup.casadocodigo.cadastroautor.controller.dto.AutorDto;
import com.zup.casadocodigo.cadastroautor.controller.form.NovoAutorForm;
import com.zup.casadocodigo.cadastroautor.modelo.Autor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<AutorDto> cadastra(@RequestBody @Valid NovoAutorForm autorForm) {

        Autor autor = autorForm.toModel();
        manager.persist(autor);
        return ResponseEntity.ok(new AutorDto(autor));
    }
}
