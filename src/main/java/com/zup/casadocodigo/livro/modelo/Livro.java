package com.zup.casadocodigo.livro.modelo;

import com.zup.casadocodigo.categoria.modelo.Categoria;
import com.zup.casadocodigo.autor.modelo.Autor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String titulo;
    @NotNull
    @NotBlank
    private String isbn;

    @NotNull
    @NotBlank
    @Size(max = 500)
    private String resumo;

    @Column(columnDefinition = "LONGTEXT")
    private String sumario;
    @DecimalMin(value = "20")
    private BigDecimal preco;

    @Min(100)
    private Integer paginas;

    @Future
    @NotNull
    private LocalDate dataPublicacao;

    @ManyToOne
    @NotNull
    private Autor autor;

    @ManyToOne
    @NotNull
    private Categoria categoria;

    @Deprecated
    public Livro() {
    }

    public Livro(@NotNull @NotBlank String titulo, @NotNull @NotBlank String isbn, @NotNull @NotBlank @Size(max = 500) String resumo, String sumario, @DecimalMin(value = "20") BigDecimal preco, @Size(min = 100) Integer paginas, @Future LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
        this.categoria = categoria;
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

    public Autor getAutor() {
        return autor;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}
