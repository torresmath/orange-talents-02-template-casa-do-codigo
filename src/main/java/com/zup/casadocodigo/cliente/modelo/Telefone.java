package com.zup.casadocodigo.cliente.modelo;

import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "cliente_telefone")
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private int ddd;

    @NotNull
    private int numero;

    @NotNull
    @OneToOne
    private Cliente cliente;

    public Telefone(@Length(min = 2, max = 2) int ddd, @Length(min = 8, max = 9) int numero, Cliente cliente) {
        this.ddd = ddd;
        this.numero = numero;
        this.cliente = cliente;
    }
}
