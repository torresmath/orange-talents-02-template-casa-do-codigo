package com.zup.casadocodigo.cadastroautor.repository;

import com.zup.casadocodigo.cadastroautor.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>, CrudRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);
}
