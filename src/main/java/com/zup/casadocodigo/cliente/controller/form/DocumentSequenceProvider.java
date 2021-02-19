package com.zup.casadocodigo.cliente.controller.form;


import com.zup.casadocodigo.common.Document;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class DocumentSequenceProvider implements DefaultGroupSequenceProvider<Document> {
    @Override
    public List<Class<?>> getValidationGroups(Document form) {
        ArrayList<Class<?>> groups = new ArrayList<>();
        groups.add(Document.class);
        if (isValid(form)) {
            groups.add(form.getTipo().getGroup());
        }

        return groups;
    }

    protected boolean isValid(Document form) {
        return form != null && form.getTipo() != null;
    }
}
