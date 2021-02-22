package com.zup.casadocodigo.cliente.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void teste_documento_regex() {

        String documento = "425.497.898-73";
        String documento1 = "425497898-73";
        String documento2 = "425.497.89873";
        String documento3 = "425-497-898-73";

        String saida = documento.replaceAll("[.-]", "");
        String saida1 = documento1.replaceAll("[.-]", "");
        String saida2 = documento2.replaceAll("[.-]", "");
        String saida3 = documento3.replaceAll("[.-]", "");

        assertEquals("42549789873", saida);
        assertEquals("42549789873", saida1);
        assertEquals("42549789873", saida2);
        assertEquals("42549789873", saida3);

    }

}