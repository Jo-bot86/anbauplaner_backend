package de.nadu_ocholt.anbauplaner.domain.shared.vaildidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RangeValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRange {
    String message() default "min must not be greater than max";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
