package com.zup.casadocodigo.cliente.controller;

import com.zup.casadocodigo.cliente.controller.form.NovoClienteForm;
import com.zup.casadocodigo.estado.modelo.Estado;
import com.zup.casadocodigo.pais.modelo.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class EstadoPertenceAPaisValidator implements Validator {

    private static final String ENDERECO_ID_ESTADO = "endereco.idEstado";

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoClienteForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        if (errors.hasErrors()) {
            return;
        }

        NovoClienteForm request = (NovoClienteForm) target;

        Pais pais = manager.find(Pais.class, request.getIdPais());

        boolean paisPossuiEstados = pais.possuiEstados(manager);

        System.out.println("paisPossuiEstados = " + paisPossuiEstados);

        if (!paisPossuiEstados && request.getIdEstado() == null) {
            return;
        }

        if (paisPossuiEstados && request.getIdEstado() == null) {
            System.out.println("Estado nulo");
            errors.rejectValue(ENDERECO_ID_ESTADO, "É necessário escolher um estado para o país selecionado");
            return;
        }

        Estado estado = manager.find(Estado.class, request.getIdEstado());

        if (estado == null) {
            errors.rejectValue(ENDERECO_ID_ESTADO,  "Estado não encontrado");
            return;
        }

        if (!estado.pertenceAPais(pais)) {
            System.out.println("Estado nao pertence a pais");
            errors.rejectValue(ENDERECO_ID_ESTADO,  "Estado não pertence ao país selecionado");
        }
    }
}
