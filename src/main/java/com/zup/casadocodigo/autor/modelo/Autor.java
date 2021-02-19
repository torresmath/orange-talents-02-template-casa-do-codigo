package com.zup.casadocodigo.autor.modelo;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotEmpty
    private String nome;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 400)
    private String descricao;

    @NotNull
    private final LocalDateTime dataCricao = LocalDateTime.now();

    public Autor(@NotNull @NotBlank String nome,
                 @NotNull @NotBlank @Email String email,
                 @NotNull @NotBlank @Size(min = 1, max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor(Long idAutor) {
        this.id = idAutor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCricao=" + dataCricao +
                '}';
    }

    @Deprecated
    public Autor() {
    }
}
