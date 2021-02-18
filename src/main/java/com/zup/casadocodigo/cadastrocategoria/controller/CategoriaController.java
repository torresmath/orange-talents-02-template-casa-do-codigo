package com.zup.casadocodigo.cadastrocategoria.controller;

import com.zup.casadocodigo.cadastrocategoria.controller.dto.CategoriaDto;
import com.zup.casadocodigo.cadastrocategoria.controller.form.NovaCategoriaForm;
import com.zup.casadocodigo.cadastrocategoria.modelo.Categoria;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @PersistenceContext
    EntityManager manager;

    @PostMapping
    @Transactional
    public CategoriaDto cria(@RequestBody @Valid NovaCategoriaForm categoriaForm) {
        Categoria categoria = categoriaForm.toModel();
        manager.persist(categoria);

        return new CategoriaDto(categoria);
    }
}
