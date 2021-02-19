package com.zup.casadocodigo.livro.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.casadocodigo.livro.modelo.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalhesResponse {
    private final Long id;
    private final String titulo;
    private final String isbn;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer paginas;

    @JsonProperty("data_publicacao")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private final LocalDate dataPublicacao;

    private final LivroAutorDetalhesResponse autor;

    public LivroDetalhesResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.preco = livro.getPreco();
        this.paginas = livro.getPaginas();
        this.dataPublicacao = livro.getDataPublicacao();

        this.autor = new LivroAutorDetalhesResponse(livro.getAutor());
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public LivroAutorDetalhesResponse getAutor() {
        return autor;
    }
}
