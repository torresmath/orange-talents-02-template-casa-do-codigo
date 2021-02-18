package com.zup.casadocodigo.cadastrolivro.controller;

import com.zup.casadocodigo.cadastrolivro.controller.dto.LivroDetalhesResponse;
import com.zup.casadocodigo.cadastrolivro.controller.dto.LivroDto;
import com.zup.casadocodigo.cadastrolivro.controller.form.NovoLivroForm;
import com.zup.casadocodigo.cadastrolivro.modelo.Livro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @PersistenceContext
    EntityManager manager;

    @GetMapping
    @Transactional
    public List<LivroDto> lista() {
        return manager.createQuery("select l from Livro l", Livro.class)
                .getResultStream()
                .map(LivroDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroDetalhesResponse> detalhes(@PathVariable Long id) {

        return Optional.ofNullable(manager.find(Livro.class, id))
                .map(livro -> ResponseEntity.ok(new LivroDetalhesResponse(livro)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @Transactional
    public LivroDto cria(@RequestBody @Valid NovoLivroForm livroForm) {

        Livro livro = livroForm.toModel(manager);
        manager.persist(livro);
        return new LivroDto(livro);
    }


}
