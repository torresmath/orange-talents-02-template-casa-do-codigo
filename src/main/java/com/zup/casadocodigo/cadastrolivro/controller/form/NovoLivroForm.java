package com.zup.casadocodigo.cadastrolivro.controller.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zup.casadocodigo.cadastroautor.modelo.Autor;
import com.zup.casadocodigo.cadastrocategoria.modelo.Categoria;
import com.zup.casadocodigo.cadastrolivro.modelo.Livro;
import com.zup.casadocodigo.common.ExistsId;
import com.zup.casadocodigo.common.UniqueValue;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class NovoLivroForm {

    @NotNull(message = "{not_null}")
    @NotBlank(message = "{not_blank}")
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private final String titulo;

    @NotNull(message = "{not_null}")
    @NotBlank(message = "{not_blank}")
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "{livro.duplicated_isbn}")
    private final String isbn;

    @NotNull(message = "{not_null}")
    @NotBlank(message = "{not_blank}")
    @Size(max = 500)
    private final String resumo;

    private final String sumario;

    @DecimalMin(value = "20", message = "{livro.preco_min}")
    private final BigDecimal preco;

    @Min(100)
    @NotNull
    private final Integer paginas;

    @Future
    @JsonProperty("data_publicacao")
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private final LocalDate dataPublicacao;

    @JsonProperty("id_autor")
    @NotNull(message = "{not_null}")
    @Positive
    @ExistsId(domainClass = Autor.class, message = "{not_found_autor}")
    private final Long idAutor;

    @JsonProperty("id_categoria")
    @NotNull(message = "{not_null}")
    @Positive
    @ExistsId(domainClass = Categoria.class, message = "{not_found_categoria}")
    private final Long idCategoria;

    public NovoLivroForm(@NotNull(message = "{not_null}") @NotBlank(message = "{not_blank}") String titulo, @NotNull(message = "{not_null}") @NotBlank(message = "{not_blank}") String isbn, @NotNull(message = "{not_null}") @NotBlank(message = "{not_blank}") @Size(max = 500) String resumo, String sumario, @DecimalMin(value = "20", message = "{livro.preco_min}") BigDecimal preco, @Min(100) @NotNull Integer paginas, @Future LocalDate dataPublicacao, @NotNull(message = "{not_null}") @Positive Long idAutor, @NotNull(message = "{not_null}") @Positive Long idCategoria) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.paginas = paginas;
        this.dataPublicacao = dataPublicacao;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    public Livro toModel(EntityManager manager) {

        Autor autor = manager.find(Autor.class, idAutor);
        Categoria categoria = manager.find(Categoria.class, idCategoria);

        Assert.state(autor != null, "Tentando salvar livro com AUTOR nulo");
        Assert.state(categoria != null, "Tentando salvar livro com CATEGORIA nula");

        return new Livro(titulo, isbn, resumo, sumario, preco, paginas, dataPublicacao, autor, categoria);
    }

}
