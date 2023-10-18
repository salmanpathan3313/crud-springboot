package com.practical.details.config.exception;


import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
//@Constraint(validatedBy = NotNullValidator.class)
@Target({ElementType.METHOD, ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullConstraint {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
