package com.zup.casadocodigo.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {CpfOrCnpjValidator.class})
public @interface CPForCNPJ {

    String message() default "CPF/CNPJ inválido";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
