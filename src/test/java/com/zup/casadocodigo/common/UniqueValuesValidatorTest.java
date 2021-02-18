package com.zup.casadocodigo.common;

import com.zup.casadocodigo.cadastroestado.modelo.Estado;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class UniqueValuesValidatorTest {

    @Test
    public void test_query_builder() {

        List<String> fields = Arrays.asList("nome", "id_pais");
        String query = queryBuilder(fields, Estado.class);

        System.out.println("query = " + query);
    }

    protected String queryBuilder(List<String> fields, Class<?> klass) {
        String filter = IntStream.range(1, fields.size())
                .mapToObj(fields::get)
                .map(field -> " and " + field + " = :" + field)
                .collect(Collectors.joining());

        String firstField = fields.get(0);

        return  "select 0 from " + klass.getName() + " where " + firstField +" = :"+ firstField + filter;
    }
}