package com.zup.casadocodigo.autor.controller;

import com.zup.casadocodigo.autor.controller.dto.AutorDto;
import com.zup.casadocodigo.autor.controller.form.NovoAutorForm;
import com.zup.casadocodigo.autor.modelo.Autor;
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
