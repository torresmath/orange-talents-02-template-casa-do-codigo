package com.zup.casadocodigo.common;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.*;
import java.util.Set;

public class CpfOrCnpjValidator implements ConstraintValidator<CPForCNPJ, String> {

    @Override
    public boolean isValid(String document, ConstraintValidatorContext context) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<DocumentValidator>> cpfViolations = validator
                .validate(new DocumentValidator(document));
        int size = cpfViolations.size();
        return size < 2;
    }

    static class DocumentValidator {

        @CPF
        @CNPJ
        private final String document;

        public DocumentValidator(String documento) {
            this.document = documento;
        }
    }
}
