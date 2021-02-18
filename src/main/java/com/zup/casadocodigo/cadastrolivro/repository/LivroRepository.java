package com.zup.casadocodigo.cadastrolivro.repository;

import com.zup.casadocodigo.cadastrolivro.modelo.Livro;
import org.springframework.data.repository.CrudRepository;

public interface LivroRepository extends CrudRepository<Livro, Long> {
}
