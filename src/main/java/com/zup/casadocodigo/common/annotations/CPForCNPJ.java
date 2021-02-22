package com.zup.casadocodigo.common.annotations;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation
@CPF
@CNPJ
@ConstraintComposition(CompositionType.OR)
public @interface CPForCNPJ {

    String message() default "CPF/CNPJ inválido";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
